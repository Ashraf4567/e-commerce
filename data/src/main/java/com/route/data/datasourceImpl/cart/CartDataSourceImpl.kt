package com.route.data.datasourceImpl.cart

import android.util.Log
import com.route.data.api.WebServices
import com.route.data.dataSourceContract.cartContract.CartDataSource
import com.route.domain.module.Cart
import javax.inject.Inject

class CartDataSourceImpl @Inject constructor(val webServices: WebServices)
    : CartDataSource{
    override suspend fun getCart(token: String): Cart? {
        val res =  webServices.getCart(token).data?.mapToCartResponse()
        Log.d("cart" , "network ${res?.products?.get(1)?.title.toString()}")
        return res
    }

    override suspend fun removeCartItem(productId: String, token: String): Cart? {
        val res = webServices.removeCartItem(productId , token)
        Log.d("cart" , "numberOfItems ${res.data?.products?.size.toString()}")
        return res.data?.mapToCartResponse()
    }
}