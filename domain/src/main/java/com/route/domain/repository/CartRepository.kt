package com.route.domain.repository

import com.route.domain.module.Cart

interface CartRepository {
    suspend fun getCartList(token: String): Cart?
}