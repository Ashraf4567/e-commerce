package com.route.domain.repository

import com.route.domain.module.AddProductRequest
import com.route.domain.module.AddToCartResponse

interface AddToCartRepository {
    suspend fun addToCart(id: AddProductRequest , token: String): AddToCartResponse
}