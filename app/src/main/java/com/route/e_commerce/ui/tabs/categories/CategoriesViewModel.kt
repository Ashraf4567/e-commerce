package com.route.e_commerce.ui.tabs.categories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.route.domain.usecases.GetSubCategoriesUseCase
import com.route.domain.usecases.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoriesViewModel @Inject constructor(
    private val categoryUseCase: GetCategoriesUseCase,
    private val subCategoriesUseCase: GetSubCategoriesUseCase
) :ViewModel() , CategoriesContract.ViewModel {

    private val _states = MutableLiveData<CategoriesContract.State>()
    override val states = _states
    private val _events = MutableLiveData<CategoriesContract.Event>()
    override val events = _events

    init {
        invokeAction(CategoriesContract.Action.LoadCategories)
    }

    private fun getSubCategoriesById(id: String?){
        viewModelScope.launch {
            try {
                _states.postValue(CategoriesContract.State.Loading(message = "loading.."))
                val data = subCategoriesUseCase.invoke(id)
                _states.postValue(CategoriesContract.State.SuccessSubCategory(data ?: listOf()))
            }catch (e: Exception){
                _states.postValue(
                    CategoriesContract.State.Error(
                        e.localizedMessage ?: "something went wrong"
                    )
                )
            }
        }
    }
    override fun invokeAction(action: CategoriesContract.Action) {
        when(action){
            is CategoriesContract.Action.LoadCategories ->{
                loadCategories()
            }
            is CategoriesContract.Action.CategoryClicked ->{
                getSubCategoriesById(action.category.id.toString())
            }
        }
    }

    private fun loadCategories() {
        viewModelScope.launch {
            try {
                _states.postValue(CategoriesContract.State.Loading(message = "loading.."))
                val data =  categoryUseCase.invoke()
                _states.postValue(CategoriesContract.State.Success(data ?: listOf()))
            }catch (e: Exception){
                _states.postValue(
                    CategoriesContract.State.Error(
                        e.localizedMessage ?: "something went wrong"
                    )
                )
            }
        }
    }


}