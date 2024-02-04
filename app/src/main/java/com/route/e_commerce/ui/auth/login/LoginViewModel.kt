package com.route.e_commerce.ui.auth.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.module.LoginRequest
import com.route.domain.usecases.LoginUseCase
import com.route.e_commerce.util.ControlState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()

    val emailError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()

    val state = MutableLiveData<ControlState>()

    fun login(){
        if (!validData()){
            return
        }
        state.postValue(ControlState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val request = LoginRequest(email = email.value , password = password.value)
                val response = loginUseCase.invoke(request)
                if (response.statusMessage == "success"){
                    state.postValue(ControlState.SUCCESS)
                    loginUseCase.sessionManager.saveUserData(response)
                    Log.d("user response" , "the token is ${loginUseCase.sessionManager.getUserData()?.name}")
                }
            }catch (e: Exception){
                state.postValue(ControlState.ERROR)
            }



        }

    }

    private fun validData(): Boolean{
        var isValid = true

        if(email.value.isNullOrBlank()){
            isValid = false
            emailError.postValue("please enter your email")
            Log.d("test error" , "error posted")
        }else{
            emailError.postValue(null)
        }
        if(password.value.isNullOrBlank()){
            isValid = false
            passwordError.postValue("please enter your password")
        }else{
            passwordError.postValue(null)
        }
        return isValid
    }
}