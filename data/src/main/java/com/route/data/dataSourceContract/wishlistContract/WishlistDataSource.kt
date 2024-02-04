package com.route.data.dataSourceContract.wishlistContract

import com.route.domain.module.Product

interface WishlistDataSource {

    suspend fun getWishlist(token: String): List<Product?>?
}