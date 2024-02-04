package com.route.data.repository.authRepo

import com.route.data.dataSourceContract.authContract.SignupDataSource
import com.route.domain.module.SignupRequest
import com.route.domain.module.UserResponse
import com.route.domain.repository.SignupRepository
import javax.inject.Inject


class SignupRepositoryImpl @Inject constructor(val dataSource: SignupDataSource) : SignupRepository {
    override suspend fun signup(signupRequest: SignupRequest): UserResponse {
    val response = dataSource.signup(signupRequest)
        return response.mapToUser()
    }
}