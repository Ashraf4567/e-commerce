package com.route.domain.usecases

import com.route.domain.module.Product
import com.route.domain.repository.ProductsRepository
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(private val repo: ProductsRepository) {
    suspend fun invoke(): List<Product?>?{
        return repo.getAllProducts()
    }
}