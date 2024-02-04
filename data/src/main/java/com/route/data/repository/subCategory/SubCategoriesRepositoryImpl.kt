package com.route.data.repository.subCategory

import com.route.data.dataSourceContract.subcategoryContract.SubCategoryDataSource
import com.route.domain.module.SubCategory
import com.route.domain.repository.SubCategoriesRepository
import javax.inject.Inject

class SubCategoriesRepositoryImpl @Inject constructor(
    private val subCategoryDataSource: SubCategoryDataSource)
    : SubCategoriesRepository {
    override suspend fun getAllSubCategoriesInCategory(id: String?): List<SubCategory?>? {
        return subCategoryDataSource.getSubCategoriesById(id)
    }
}