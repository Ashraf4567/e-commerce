package com.route.data.datasourceImpl.product

import android.util.Log
import com.route.data.api.WebServices
import com.route.data.dataSourceContract.productContract.SpecificProductDataSource
import com.route.domain.module.Product
import javax.inject.Inject

class SpecificProductDataSourceImpl @Inject constructor(val webServices: WebServices)
    : SpecificProductDataSource {
    override suspend fun getSpecificProduct(productId: String): Product? {
        val res = webServices.getSpecificProduct(productId).data?.mapToProduct()
        Log.d("product response" , "response from data ${res?.title}")
        return res
    }
}