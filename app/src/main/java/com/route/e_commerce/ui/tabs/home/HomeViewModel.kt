package com.route.e_commerce.ui.tabs.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.module.Category
import com.route.domain.module.Product
import com.route.domain.usecases.GetProductsUseCase
import com.route.domain.usecases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryUseCase: GetCategoriesUseCase,
    private val productsUseCase: GetProductsUseCase
): ViewModel() {

    val categoriesLiveData = MutableLiveData<List<Category?>?>()
    val productsLiveData = MutableLiveData<List<Product?>?>()

    init {
        getCategories()
        getProducts()
    }

     private fun getCategories(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val list =  categoryUseCase.invoke()
                categoriesLiveData.postValue(list)
            }catch (e: Exception){
                Log.d("error" , "error")
            }

        }

    }

    fun getProducts(){
        viewModelScope.launch(Dispatchers.IO) {
            val list = productsUseCase.invoke()
//            val filtered :MutableList<Product?>? = null
//            list?.forEach {
//                if (it?.category?.name == "Electronics"){
//                    filtered?.add(it)
//                }
//
//            }
            productsLiveData.postValue(list)
        }
    }
}