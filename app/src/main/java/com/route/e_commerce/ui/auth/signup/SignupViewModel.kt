package com.route.e_commerce.ui.auth.signup

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.module.SignupRequest
import com.route.domain.usecases.SignupUseCase
import com.route.e_commerce.util.Message
import com.route.e_commerce.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SignupViewModel @Inject constructor(
    private val signupUseCase: SignupUseCase,
): ViewModel() {


    val messageLiveData = SingleLiveEvent<Message>()

    val userName = MutableLiveData<String>("sayed")
    val email = MutableLiveData<String>()
    val phone = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val passwordConfirmation = MutableLiveData<String>()

    val userNameError = MutableLiveData<String?>()
    val emailError = MutableLiveData<String?>()
    val phoneError = MutableLiveData<String?>()
    val passwordError = MutableLiveData<String?>()
    val passwordConfirmationError = MutableLiveData<String?>()
    val stateLiveData = MutableLiveData<SignupState>()

     fun signupUser(){
         stateLiveData.postValue(SignupState.LOADING)
         if (!validForm()){
             stateLiveData.postValue(SignupState.ERROR)
             return
         }

             viewModelScope.launch {
                 try {
                     val request = SignupRequest(password = password.value
                         , phone = phone.value,
                         rePassword = passwordConfirmation.value , name = userName.value , email = email.value)
                     val respone = signupUseCase.invoke(request)

                     if (respone.statusMessage == "success"){
                         stateLiveData.postValue(SignupState.SUCCESS)
                         signupUseCase.sessionManger.saveUserData(respone)
                         Log.d("user response" , "the token is ${signupUseCase.sessionManger.getUserData()?.token}")
                 }

                 }catch (e: Exception){
                     stateLiveData.postValue(SignupState.ERROR)
                 }

             }

    }

    private fun validForm(): Boolean {
        var isValid = true
        if (userName.value.isNullOrBlank()) {
            //showError
            userNameError.postValue("please enter user name")
            isValid = false
            Log.d("user response" , "please enter user name")
        } else {
            userNameError.postValue(null)
        }
        if (phone.value.isNullOrBlank()){
            phoneError.postValue("please enter your phone number")
        }else{
            phoneError.postValue(null)
        }
        if (email.value.isNullOrBlank()) {
            //showError
            emailError.postValue("please enter email")
            isValid = false
        } else {
            emailError.postValue(null)
        }
        if (password.value.isNullOrBlank()) {
            //showError
            passwordError.postValue("please enter password")
            isValid = false
        } else {
            passwordError.postValue(null)
        }
        if (passwordConfirmation.value.isNullOrBlank() ||
            passwordConfirmation.value != password.value
        ) {
            //showError
            passwordConfirmationError.postValue("passwords doesn't match")
            isValid = false
        } else {
            passwordConfirmationError.postValue(null)
        }
        return isValid
    }
}