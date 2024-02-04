package com.route.domain.usecases

import com.route.domain.module.Category
import com.route.domain.repository.CategoriesRepository

import javax.inject.Inject


class GetCategoriesUseCase @Inject constructor (val repository: CategoriesRepository){

   suspend fun invoke():List<Category?>?{
       return repository.getAllCategories()
    }
}