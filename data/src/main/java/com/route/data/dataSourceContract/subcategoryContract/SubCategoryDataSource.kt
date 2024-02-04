package com.route.data.dataSourceContract.subcategoryContract

import com.route.domain.module.SubCategory

interface SubCategoryDataSource {
    suspend fun getSubCategoriesById(id: String?): List<SubCategory?>?
}