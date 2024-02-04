package com.route.data.dataSourceContract.cartContract

import com.route.domain.module.AddProductRequest
import com.route.domain.module.AddToCartResponse

interface AddToCartDataSource {
    suspend fun addToCart(id: AddProductRequest , token: String): AddToCartResponse
}