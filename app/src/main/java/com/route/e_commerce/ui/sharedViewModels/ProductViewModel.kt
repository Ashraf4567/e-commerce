package com.route.e_commerce.ui.sharedViewModels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.module.AddProductRequest
import com.route.domain.module.Product
import com.route.domain.usecases.AddToCartUseCase
import com.route.domain.usecases.AddToWishlistUseCase
import com.route.domain.usecases.SpecificProductUseCase
import com.route.e_commerce.util.ControlState
import com.route.e_commerce.util.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor (
    private val specificProductUseCase: SpecificProductUseCase,
    private val addToWishlistUseCase: AddToWishlistUseCase,
    private val addToCartUseCase: AddToCartUseCase
): ViewModel() {

    private val _productResData: MutableStateFlow<Product?> = MutableStateFlow(null)
    val productResData: StateFlow<Product?> =  _productResData
    val state = MutableLiveData<ControlState>()
    val testAdd = SingleLiveEvent<String>()

    fun getProduct(id: String?){
        state.postValue(ControlState.LOADING)
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val product =
                    specificProductUseCase.invoke(id!!)
                _productResData.emit(product)
                state.postValue(ControlState.SUCCESS)
            }catch (e: Exception){
                Log.d("product response" , "error")
            }

        }
    }

    fun addToWishlist(id: String?){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = addToWishlistUseCase.invoke(
                    AddProductRequest(id?:""), token = addToWishlistUseCase.sessionManager
                    .getUserData()?.token?:"")
                Log.d("product Tag" , response.message.toString())

                if (response.status == "success"){
                    testAdd.postValue(response.message?:"")
                }
            }catch (e: Exception){
                testAdd.postValue(e.message?:"")
            }


        }
    }

    fun addToCart(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response =  addToCartUseCase.invoke(AddProductRequest(
                    id) , addToCartUseCase.sessionManager.getUserData()?.token?:"")
                if (response.status == "success"){
                    testAdd.postValue(response.message?:"")
                }
            }catch (e: Exception){
                testAdd.postValue(e.message?:"")
            }
        }
    }
}