package com.route.domain.repository

import com.route.domain.module.Product

interface WishListRepository {

    suspend fun getWishlist(token: String): List<Product?>?
}