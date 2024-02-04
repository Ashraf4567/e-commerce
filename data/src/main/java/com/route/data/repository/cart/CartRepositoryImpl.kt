package com.route.data.repository.cart

import com.route.data.dataSourceContract.cartContract.CartDataSource
import com.route.domain.module.Cart
import com.route.domain.repository.CartRepository
import javax.inject.Inject

class CartRepositoryImpl @Inject constructor(private val cartDataSource: CartDataSource): CartRepository {

    override suspend fun getCartList(token: String): Cart? {
        return cartDataSource.getCart(token)
    }
}