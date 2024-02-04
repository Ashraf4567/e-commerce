package com.route.data.dataSourceContract.productContract

import com.route.domain.module.Product

interface ProductsDatasource {
    suspend fun getProducts(): List<Product?>?
}