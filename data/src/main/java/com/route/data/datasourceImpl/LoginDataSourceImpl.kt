package com.route.data.datasourceImpl

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.authContract.LoginDataSource
import com.route.data.model.signup.AuthResponse
import com.route.domain.module.LoginRequest
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(private val webServices: WebServices):
    LoginDataSource {
    override suspend fun login(loginRequest: LoginRequest): AuthResponse {
        return webServices.login(loginRequest)
    }
}