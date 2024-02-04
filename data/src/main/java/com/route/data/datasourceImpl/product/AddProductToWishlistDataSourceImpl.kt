package com.route.data.datasourceImpl.product

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.productContract.AddProductToWishlistDataSource
import com.route.domain.module.AddProductToWishListResponse
import com.route.domain.module.AddProductRequest
import javax.inject.Inject

class AddProductToWishlistDataSourceImpl @Inject constructor(private val webServices: WebServices)
    : AddProductToWishlistDataSource{
    override suspend fun addProductToWishlist(token: String, id: AddProductRequest): AddProductToWishListResponse {
        return webServices.addProductToWishlist(token = token , productId = id)
            .mapToAddProductResponse()
    }
}