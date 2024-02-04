package com.route.data.repository.categories

import com.route.data.dataSourceContract.categoryContract.CategoryDataSource
import com.route.domain.module.Category
import com.route.domain.repository.CategoriesRepository
import javax.inject.Inject

class CategoriesRepositoryImpl @Inject constructor(private val categoryDataSource: CategoryDataSource):CategoriesRepository {
    override suspend fun getAllCategories(): List<Category?>? {
     return categoryDataSource.getAllCategories()
    }
}