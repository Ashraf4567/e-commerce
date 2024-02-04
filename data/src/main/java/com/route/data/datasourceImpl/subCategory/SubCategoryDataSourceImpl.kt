package com.route.data.datasourceImpl.subCategory

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.subcategoryContract.SubCategoryDataSource
import com.route.domain.module.SubCategory
import javax.inject.Inject

class SubCategoryDataSourceImpl@Inject constructor(private var webServices: WebServices): SubCategoryDataSource {
    override suspend fun getSubCategoriesById(id: String?): List<SubCategory?>? {
        val response = webServices.getAllSubCategoriesById(id)
        return response.data?.map {
            it?.toSubCategory()
        }
    }
}