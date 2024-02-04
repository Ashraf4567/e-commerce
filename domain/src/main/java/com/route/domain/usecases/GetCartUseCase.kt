package com.route.domain.usecases

import com.route.domain.module.Cart
import com.route.domain.repository.CartRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class GetCartUseCase @Inject constructor(
     val repository: CartRepository,
     val sessionManager: SessionManager) {

    suspend fun invoke(token: String): Cart?{
        return repository.getCartList(token)
    }
}