package com.route.domain.usecases

import com.route.domain.module.Product
import com.route.domain.repository.SpecificProductRepository
import javax.inject.Inject

class SpecificProductUseCase @Inject constructor( val repository: SpecificProductRepository) {
    suspend fun invoke(productId: String): Product?{
        return repository.getSpecificProduct(productId)
    }
}