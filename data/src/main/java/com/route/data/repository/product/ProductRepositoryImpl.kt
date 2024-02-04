package com.route.data.repository.product

import com.route.data.dataSourceContract.productContract.ProductsDatasource
import com.route.domain.module.Product
import com.route.domain.repository.ProductsRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor
    (val productDataSource: ProductsDatasource): ProductsRepository {
    override suspend fun getAllProducts(): List<Product?>? {
        return productDataSource.getProducts()
    }
}