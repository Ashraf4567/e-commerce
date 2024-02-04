package com.route.data.dataSourceContract.authContract

import com.route.data.model.signup.AuthResponse
import com.route.domain.module.SignupRequest

interface SignupDataSource {
    suspend fun signup(userSignupRequest: SignupRequest): AuthResponse
}