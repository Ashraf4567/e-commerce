package com.route.domain.repository

import com.route.domain.module.Category

interface CategoriesRepository {
   suspend  fun getAllCategories():List<Category?>?
}