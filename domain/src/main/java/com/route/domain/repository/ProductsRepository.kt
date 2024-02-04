package com.route.domain.repository

import com.route.domain.module.Product

interface ProductsRepository {
    suspend fun getAllProducts(): List<Product?>?
}