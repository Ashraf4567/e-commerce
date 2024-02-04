package com.route.domain.repository

import com.route.domain.module.Cart

interface RemoveCartItemRepository {
    suspend fun removeCartItem(id: String, token: String): Cart?
}