package com.route.data.repository.authRepo

import com.route.data.dataSourceContract.authContract.LoginDataSource
import com.route.domain.module.LoginRequest
import com.route.domain.module.UserResponse
import com.route.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginDataSource: LoginDataSource): LoginRepository {
    override suspend fun login(loginRequest: LoginRequest): UserResponse {
        val response = loginDataSource.login(loginRequest)
        return response.mapToUser()
    }
}