package com.route.domain.repository

import com.route.domain.module.SignupRequest
import com.route.domain.module.UserResponse

interface SignupRepository {
    suspend fun signup(signupRequest: SignupRequest): UserResponse
}