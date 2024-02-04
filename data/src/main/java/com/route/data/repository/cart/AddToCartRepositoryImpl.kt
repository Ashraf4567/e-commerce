package com.route.data.repository.cart

import com.route.data.dataSourceContract.cartContract.AddToCartDataSource
import com.route.domain.module.AddProductRequest
import com.route.domain.module.AddToCartResponse
import com.route.domain.repository.AddToCartRepository
import javax.inject.Inject

class AddToCartRepositoryImpl @Inject constructor(private val addToCartDataSource: AddToCartDataSource)
    :AddToCartRepository {
    override suspend fun addToCart(id: AddProductRequest, token: String): AddToCartResponse {
        return addToCartDataSource.addToCart(id, token)
    }
}