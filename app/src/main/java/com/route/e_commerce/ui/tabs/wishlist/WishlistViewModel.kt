package com.route.e_commerce.ui.tabs.wishlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.usecases.WishlistUseCase
import com.route.e_commerce.util.SingleLiveEvent

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val wishlistUseCase: WishlistUseCase
): ViewModel() , WishlistContract.ViewModel {


    private val _states = MutableLiveData<WishlistContract.State>()
    override val state = _states
    private val _event = SingleLiveEvent<WishlistContract.Event>()
    override val event = _event

    init {
        invokeAction(WishlistContract.Action.LoadProducts)
    }


    override fun invokeAction(action: WishlistContract.Action) {
        when(action){
            is WishlistContract.Action.LoadProducts -> getWishlist()
            is WishlistContract.Action.ProductClicked -> navigateToProductDetailsEvent(action.id)
        }
    }

    private fun navigateToProductDetailsEvent(id: String) {
        _event.postValue(WishlistContract.Event.NavigateToProductDetails(id))
    }

    private fun getWishlist(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val token = wishlistUseCase.sessionManager.getUserData()?.token?:""
                _states.postValue(WishlistContract.State.Loading("Loading..."))
                val response= wishlistUseCase.invoke(token)
                _states.postValue(WishlistContract.State.Success(response))
            }catch (e: Exception){
                _states.postValue(WishlistContract.State.Error(e.message.toString()))
            }
        }

    }
}