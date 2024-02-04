package com.route.data.datasourceImpl.categoryImpl

import com.route.data.api.WebServices
import com.route.data.dataSourceContract.categoryContract.CategoryDataSource

import com.route.domain.module.Category
import javax.inject.Inject
////@Inject constructor
//It marks the constructor of CategoryDataSourceImpl as eligible for injection.
// This means that an instance of CategoryDataSourceImpl can be requested and provided by a dependency injection framework like Dagger/Hilt.
//When an instance of CategoryDataSourceImpl is requested,
//the DI framework will automatically resolve and provide the required dependencies,
//such as the WebServices instance, to the constructor. In this case,
//the provideCategoryDataSource method in the Di module is responsible for providing
//the CategoryDataSourceImpl instance,
//and it does so by injecting the required WebServices dependency into the constructor
//of CategoryDataSourceImpl.
class CategoryDataSourceImpl  @Inject constructor(var webServices: WebServices):CategoryDataSource {
    override suspend fun getAllCategories(): List<Category?>? {
          return webServices.getAllCategories().data?.map {
               it?.mapToCategory()
              //بيمسك it ينفذ عليها اوبرشن معينه ويحطها مكانها في نفس الاندكس
              //والقديمه بتتشال بواسطه garbage collector
            }
    }
}