package com.route.domain.repository

import com.route.domain.module.LoginRequest
import com.route.domain.module.UserResponse

interface LoginRepository {
    suspend fun login(loginRequest: LoginRequest): UserResponse
}