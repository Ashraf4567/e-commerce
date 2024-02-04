package com.route.domain.repository

import com.route.domain.module.Product

interface SpecificProductRepository {
    suspend fun getSpecificProduct(productId: String): Product?
}