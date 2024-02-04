package com.route.domain.usecases

import com.route.domain.module.LoginRequest
import com.route.domain.module.UserResponse
import com.route.domain.repository.LoginRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    val loginRepository: LoginRepository,
    val sessionManager: SessionManager
){
    suspend fun invoke(loginRequest: LoginRequest): UserResponse{
        return loginRepository.login(loginRequest)
    }
}