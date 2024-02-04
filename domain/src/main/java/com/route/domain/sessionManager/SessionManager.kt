package com.route.domain.sessionManager

import com.route.domain.module.UserResponse

interface SessionManager {
    fun saveUserData(userResponse: UserResponse)
    fun getUserData(): UserResponse?
    fun logout()
}