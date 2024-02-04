package com.route.data.repository

import android.content.SharedPreferences
import com.google.gson.Gson
import com.route.domain.module.UserResponse
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class SessionManagerImpl @Inject constructor(private val sharedPreferences: SharedPreferences): SessionManager{
    companion object {
        private const val KEY_USER_DATA = "user_data"
        private const val KEY_AUTH_TOKEN = "auth_token"
    }

    // Function to save user data
    override fun saveUserData(userResponse: UserResponse) {
        val userDataJson = Gson().toJson(userResponse)
        sharedPreferences.edit().putString(KEY_USER_DATA, userDataJson).apply()
    }

    // Function to retrieve user data
    override fun getUserData(): UserResponse? {
        val userDataJson = sharedPreferences.getString(KEY_USER_DATA, null)
        return if (userDataJson != null) {
            Gson().fromJson(userDataJson, UserResponse::class.java)
        } else {
            null
        }
    }


    // Function to clear user data and authentication token (logout)
    override fun logout() {
        sharedPreferences.edit().remove(KEY_USER_DATA).remove(KEY_AUTH_TOKEN).apply()
    }
}