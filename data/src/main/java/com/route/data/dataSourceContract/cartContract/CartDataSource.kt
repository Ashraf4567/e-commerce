package com.route.data.dataSourceContract.cartContract

import com.route.domain.module.Cart

interface CartDataSource {
    suspend fun getCart(token: String): Cart?
    suspend fun removeCartItem(productId: String , token: String): Cart?
}