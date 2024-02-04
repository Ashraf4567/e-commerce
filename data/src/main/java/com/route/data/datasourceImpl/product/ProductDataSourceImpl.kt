package com.route.data.datasourceImpl.product

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.productContract.ProductsDatasource
import com.route.domain.module.Product
import javax.inject.Inject

class ProductDataSourceImpl @Inject constructor (val webServices: WebServices): ProductsDatasource {
    override suspend fun getProducts(): List<Product?>? {
          val response = webServices.getAllProducts()
        return response.data?.map {
            it?.mapToProduct()
        }
    }
}