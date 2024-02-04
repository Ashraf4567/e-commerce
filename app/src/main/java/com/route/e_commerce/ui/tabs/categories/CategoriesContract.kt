package com.route.e_commerce.ui.tabs.categories
import androidx.lifecycle.LiveData
import com.route.domain.module.Category
import com.route.domain.module.SubCategory

class CategoriesContract {

    interface ViewModel{
        val states: LiveData<State>
        val events: LiveData<Event>
        fun invokeAction(action: Action)
    }
    sealed class State{
        class Error(val message: String): State()
        class Success(val categories: List<Category?>): State()
        class SuccessSubCategory(val subCategories: List<SubCategory?>) : State()
        class Loading(val message: String): State()
    }
    sealed class Action{
        object LoadCategories: Action()
        class CategoryClicked(val category: Category): Action()
    }
    sealed class Event{
        class NavigateToSubCategory(val id: String?): Event()
    }
}