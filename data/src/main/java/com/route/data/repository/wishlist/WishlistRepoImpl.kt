package com.route.data.repository.wishlist

import com.route.data.dataSourceContract.wishlistContract.WishlistDataSource
import com.route.domain.module.Product
import com.route.domain.repository.WishListRepository
import javax.inject.Inject

class WishlistRepoImpl @Inject constructor(
    private val wishlistDataSource: WishlistDataSource
): WishListRepository {
    override suspend fun getWishlist(token: String): List<Product?>? {
        return wishlistDataSource.getWishlist(token)
    }
}