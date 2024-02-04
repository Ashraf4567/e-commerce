package com.route.e_commerce.ui.cart

import android.net.http.HttpException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.module.Cart
import com.route.domain.usecases.GetCartUseCase
import com.route.domain.usecases.RemoveCartItemUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val getCartUseCase: GetCartUseCase,
    private val removeCartItemUseCase: RemoveCartItemUseCase
) : ViewModel() {

        private val _productsStateFlow : MutableStateFlow<Cart?> = MutableStateFlow(null)
        val productsStateFlow: StateFlow<Cart?> = _productsStateFlow
        private val token = getCartUseCase.sessionManager.getUserData()?.token?:""

    init {
        grtCart()
    }

    fun removeCartItem(id: String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _productsStateFlow.value = removeCartItemUseCase.invoke(id , token)
            }catch (e: Exception){
                Log.d("cart" , e.message.toString())
            }
        }
    }

        private fun grtCart(){
            viewModelScope.launch {
                try {
                    _productsStateFlow.value = getCartUseCase.invoke(token)
                }catch (e: Exception){
                    Log.d("cart" , e.message.toString())
                }
            }
        }
}