package com.route.domain.repository

import com.route.domain.module.AddProductToWishListResponse
import com.route.domain.module.AddProductRequest

interface AddToWishlistRepository {
    suspend fun addProductToWishlist(token: String ,id: AddProductRequest): AddProductToWishListResponse
}