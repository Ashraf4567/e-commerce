package com.route.data.dataSourceContract.productContract

import com.route.domain.module.AddProductToWishListResponse
import com.route.domain.module.AddProductRequest

interface AddProductToWishlistDataSource {
    suspend fun addProductToWishlist(token:String,id: AddProductRequest): AddProductToWishListResponse
}