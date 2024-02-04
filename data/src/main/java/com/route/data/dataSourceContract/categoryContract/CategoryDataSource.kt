package com.route.data.dataSourceContract.categoryContract

import com.route.domain.module.Category

interface CategoryDataSource {
   suspend fun getAllCategories():List<Category?>?
}