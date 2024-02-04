package com.route.e_commerce.ui.tabs.categories

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.route.domain.module.Category
import com.route.domain.module.SubCategory
import com.route.e_commerce.R
import com.route.e_commerce.databinding.FragmentCategoryBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryFragment : Fragment() {
    lateinit var viewBinding:FragmentCategoryBinding
    private val viewModelFragment: CategoriesViewModel by activityViewModels()
    private val categoriesAdapter =   CategoriesAdapter(null)
    private val subCategoriesAdapter = SubCategoriesAdapter(null)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentCategoryBinding.inflate(inflater,container,false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModelFragment.events.observe(viewLifecycleOwner,::handleEvents)
        viewModelFragment.states.observe(viewLifecycleOwner,::renderViewState)


    }

    private fun initViews() {
        categoriesAdapter.onItemClickListener = CategoriesAdapter
            .OnItemClickListener{position, item ->
                item?.let {
                    viewModelFragment.invokeAction(CategoriesContract.Action.CategoryClicked(it))
                    Glide.with(this)
                        .load(it.image)
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(viewBinding.categoryImage)
                }

        }
        viewBinding.categoriesRecycler.adapter = categoriesAdapter
        viewBinding.subCategoryRecyclerView.adapter = subCategoriesAdapter

    }

    private fun renderViewState(state: CategoriesContract.State) {
        when(state){
            is CategoriesContract.State.Loading ->showLoading(state.message)
            is CategoriesContract.State.Success -> bindCategories(state.categories)
            is CategoriesContract.State.Error ->showError(state.message)
            is CategoriesContract.State.SuccessSubCategory -> bindSubCategories(state.subCategories)
        }
    }

    private fun bindSubCategories(subCategories: List<SubCategory?>) {
        viewBinding.loadingView.isVisible = false
        viewBinding.successView.isVisible = true
        viewBinding.errorView.isVisible = false
        subCategoriesAdapter.bindSubCategories(subCategories)
    }

    private fun showError(message: String) {
        viewBinding.loadingView.isVisible = false
        viewBinding.successView.isVisible = false
        viewBinding.errorView.isVisible = true
        viewBinding.errorText.text = message
        viewBinding.tryAgainBtn.setOnClickListener{
            viewModelFragment.invokeAction(CategoriesContract.Action.LoadCategories)
        }
    }

    private fun showLoading(message: String) {
        viewBinding.loadingView.isVisible = true
        viewBinding.successView.isVisible = true
        viewBinding.errorView.isVisible = false
        viewBinding.loadingText.text = message
    }

    private fun bindCategories(categories: List<Category?>) {
        viewBinding.loadingView.isVisible = false
        viewBinding.successView.isVisible = true
        viewBinding.errorView.isVisible = false
        categoriesAdapter.bindCategories(categories)

    }

    private fun handleEvents(event: CategoriesContract.Event) {
        when(event){
            is CategoriesContract.Event.NavigateToSubCategory ->navigateToSubCategory(event.id.toString())
        }
    }

    private fun navigateToSubCategory(id: String) {
    }
}