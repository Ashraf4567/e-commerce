package com.route.data.repository.product

import com.route.data.dataSourceContract.productContract.AddProductToWishlistDataSource
import com.route.domain.module.AddProductToWishListResponse
import com.route.domain.module.AddProductRequest
import com.route.domain.repository.AddToWishlistRepository
import javax.inject.Inject

class AddProductToWishlistRepoImpl @Inject constructor (
    private val addProductToWishlistDataSource: AddProductToWishlistDataSource)
    : AddToWishlistRepository {
    override suspend fun addProductToWishlist(token: String, id: AddProductRequest): AddProductToWishListResponse {
        return addProductToWishlistDataSource.addProductToWishlist(token = token , id = id)
    }
}