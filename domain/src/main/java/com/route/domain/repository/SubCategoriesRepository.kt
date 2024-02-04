package com.route.domain.repository

import com.route.domain.module.SubCategory

interface SubCategoriesRepository {
    suspend fun getAllSubCategoriesInCategory(id: String? = "6439d40367d9aa4ca97064cc"): List<SubCategory?>?
}