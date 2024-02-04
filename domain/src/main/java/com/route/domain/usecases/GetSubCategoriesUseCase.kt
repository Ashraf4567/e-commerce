package com.route.domain.usecases

import com.route.domain.module.SubCategory
import com.route.domain.repository.SubCategoriesRepository
import javax.inject.Inject

class GetSubCategoriesUseCase @Inject constructor(
    val repository: SubCategoriesRepository
) {
    suspend fun invoke(id: String?): List<SubCategory?>?{
        return repository.getAllSubCategoriesInCategory(id)
    }
}