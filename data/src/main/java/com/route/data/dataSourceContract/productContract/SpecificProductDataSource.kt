package com.route.data.dataSourceContract.productContract

import com.route.domain.module.Product

interface SpecificProductDataSource {
    suspend fun getSpecificProduct(productId: String): Product?
}