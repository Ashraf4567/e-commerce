package com.route.e_commerce.ui.tabs.wishlist

import androidx.lifecycle.LiveData
import com.route.domain.module.Product

class WishlistContract {

    interface ViewModel{
        val event: LiveData<Event>
        val state: LiveData<State>
        fun invokeAction(action: Action)
    }

    sealed class State{
        class Loading(val message: String): State()
        class Success(val data: List<Product?>?): State()
        class Error(val message: String): State()
    }

    sealed class Action{
        object LoadProducts : Action()
        class ProductClicked(val id: String) : Action()
    }

    sealed class Event{
        class NavigateToProductDetails(val id: String): Event()
    }
}