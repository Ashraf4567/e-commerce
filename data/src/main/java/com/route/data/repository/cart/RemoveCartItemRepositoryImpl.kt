package com.route.data.repository.cart

import com.route.data.dataSourceContract.cartContract.CartDataSource
import com.route.domain.module.Cart
import com.route.domain.repository.CartRepository
import com.route.domain.repository.RemoveCartItemRepository
import javax.inject.Inject

class RemoveCartItemRepositoryImpl @Inject constructor(private val cartDataSource: CartDataSource): RemoveCartItemRepository {

    override suspend fun removeCartItem(id: String, token: String): Cart? {
        return cartDataSource.removeCartItem(id , token)
    }
}