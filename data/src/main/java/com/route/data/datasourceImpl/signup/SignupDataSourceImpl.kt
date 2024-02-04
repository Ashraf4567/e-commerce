package com.route.data.datasourceImpl.signup

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.authContract.SignupDataSource
import com.route.data.model.signup.AuthResponse
import com.route.domain.module.SignupRequest
import javax.inject.Inject

class SignupDataSourceImpl @Inject constructor(private val webServices: WebServices): SignupDataSource {
    override suspend fun signup(userSignupRequest: SignupRequest): AuthResponse {
        return webServices.signUp(userSignupRequest)


    }
}