package com.route.domain.usecases

import com.route.domain.module.Product
import com.route.domain.repository.WishListRepository
import com.route.domain.sessionManager.SessionManager
import javax.inject.Inject

class WishlistUseCase @Inject constructor(
    val wishListRepository: WishListRepository,
    val sessionManager: SessionManager
) {
    suspend fun invoke(token: String): List<Product?>?{
        return wishListRepository.getWishlist(token)
    }
}