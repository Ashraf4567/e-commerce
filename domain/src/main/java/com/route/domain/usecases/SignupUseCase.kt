package com.route.domain.usecases

import com.route.domain.module.SignupRequest
import com.route.domain.module.UserResponse
import com.route.domain.repository.SignupRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class SignupUseCase @Inject constructor(
    val repository: SignupRepository,
    val sessionManger: SessionManager
) {
    suspend fun invoke(signupRequest: SignupRequest): UserResponse {

        return repository.signup(signupRequest)
    }
}