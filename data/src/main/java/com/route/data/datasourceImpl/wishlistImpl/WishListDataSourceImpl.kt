package com.route.data.datasourceImpl.wishlistImpl

import android.util.Log
import com.route.data.api.WebServices
import com.route.data.dataSourceContract.wishlistContract.WishlistDataSource
import com.route.domain.module.Product
import javax.inject.Inject

class WishListDataSourceImpl @Inject constructor(private val webServices: WebServices): WishlistDataSource {

    override suspend fun getWishlist(token: String): List<Product?>? {
        val response = webServices.getWishList(token).data?.map {
            it?.mapToProduct()
        }
        Log.d("wishlist response" , response?.size.toString())
        return response
    }
}