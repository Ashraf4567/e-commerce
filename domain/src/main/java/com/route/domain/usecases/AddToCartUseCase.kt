package com.route.domain.usecases

import com.route.domain.module.AddProductRequest
import com.route.domain.module.AddToCartResponse
import com.route.domain.repository.AddToCartRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class AddToCartUseCase @Inject constructor(
    val addToCartRepository: AddToCartRepository,
    val sessionManager: SessionManager
) {
    suspend fun invoke(id: AddProductRequest, token:String): AddToCartResponse{
        return addToCartRepository.addToCart(id, token)
    }
}