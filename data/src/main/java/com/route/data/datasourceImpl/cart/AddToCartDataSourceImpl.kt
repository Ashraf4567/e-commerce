package com.route.data.datasourceImpl.cart

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.cartContract.AddToCartDataSource
import com.route.domain.module.AddProductRequest
import com.route.domain.module.AddToCartResponse
import javax.inject.Inject

class AddToCartDataSourceImpl @Inject constructor(val webServices: WebServices): AddToCartDataSource {

    override suspend fun addToCart(id: AddProductRequest, token: String): AddToCartResponse {
        return webServices.addToCart(productId = id , token = token)
            .mapToAddToCartResponse()
    }
}