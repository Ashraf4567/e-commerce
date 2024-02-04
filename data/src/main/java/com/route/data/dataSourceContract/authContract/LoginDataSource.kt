package com.route.data.dataSourceContract.authContract

import com.route.data.model.signup.AuthResponse
import com.route.domain.module.LoginRequest

interface LoginDataSource {
    suspend fun login(loginRequest: LoginRequest): AuthResponse
}