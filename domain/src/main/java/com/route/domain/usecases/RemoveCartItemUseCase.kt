package com.route.domain.usecases

import com.route.domain.module.Cart
import com.route.domain.repository.RemoveCartItemRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class RemoveCartItemUseCase @Inject constructor(
    private val repository: RemoveCartItemRepository,
    val sessionManager: SessionManager
) {
    suspend fun invoke(productId: String , token: String): Cart?{
        return repository.removeCartItem(productId , token)
    }
}