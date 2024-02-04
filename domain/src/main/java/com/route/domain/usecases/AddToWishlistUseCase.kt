package com.route.domain.usecases

import com.route.domain.module.AddProductToWishListResponse
import com.route.domain.module.AddProductRequest
import com.route.domain.repository.AddToWishlistRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class AddToWishlistUseCase @Inject constructor(
    private val addToWishlistRepository: AddToWishlistRepository,
    val sessionManager: SessionManager
) {
    suspend fun invoke(id: AddProductRequest, token:String): AddProductToWishListResponse{
        return addToWishlistRepository.addProductToWishlist(id = id , token = token)
    }
}