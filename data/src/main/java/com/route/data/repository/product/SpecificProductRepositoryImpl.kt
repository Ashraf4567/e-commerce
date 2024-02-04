package com.route.data.repository.product

import com.route.data.dataSourceContract.productContract.SpecificProductDataSource
import com.route.domain.module.Product
import com.route.domain.repository.SpecificProductRepository
import javax.inject.Inject

class SpecificProductRepositoryImpl @Inject constructor
    (private val specificProductDataSource: SpecificProductDataSource): SpecificProductRepository {

    override suspend fun getSpecificProduct(productId: String): Product? {
        return specificProductDataSource.getSpecificProduct(productId)
    }
}