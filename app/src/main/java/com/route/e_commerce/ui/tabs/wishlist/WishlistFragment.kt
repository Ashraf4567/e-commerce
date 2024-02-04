package com.route.e_commerce.ui.tabs.wishlist

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.route.domain.module.Product
import com.route.e_commerce.databinding.FragmentWishlistBinding
import com.route.e_commerce.ui.productScreen.ProductDetailsActivity
import com.route.e_commerce.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WishlistFragment : Fragment() {
    private lateinit var viewBinding: FragmentWishlistBinding
    private val viewModel: WishlistViewModel by viewModels()
    private var wishlistAdapter = WishlistAdapter(mutableListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("creation test","WishlistFragment is created")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding= FragmentWishlistBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()




        initObservers()
    }
    private fun initViews() {
        viewBinding.productsRecycler.adapter = wishlistAdapter

        wishlistAdapter.onProductClickListener = WishlistAdapter.OnProductClickListener { id ->

            viewModel.invokeAction(WishlistContract.Action.ProductClicked(id))
        }
    }

    private fun initObservers() {
        viewModel.state.observe(viewLifecycleOwner , ::renderViewState)
        viewModel.event.observe(viewLifecycleOwner , ::handleEvents)
    }

    private fun handleEvents(event: WishlistContract.Event?) {
        when(event){
            is WishlistContract.Event.NavigateToProductDetails ->navigateToProductDetails(event.id)
            null -> {}
        }
    }

    private fun navigateToProductDetails(id: String) {
        val intent = Intent(requireActivity() , ProductDetailsActivity::class.java).apply {
            putExtra(Constants.PRODUCT_ID , id)
        }

    }

    private fun renderViewState(state: WishlistContract.State?) {
        when(state){
            is WishlistContract.State.Error -> handleError(state.message)
            is WishlistContract.State.Loading -> handleLoading()
            is WishlistContract.State.Success -> handleSuccess(state.data?: mutableListOf())
            else -> {}
        }
    }

    private fun handleError(message: String) {

        viewBinding.notFoundView.isVisible = true
    }

    private fun handleSuccess(products: List<Product?>) {
        viewBinding.loadingView.isVisible = false
        viewBinding.successView.isVisible = true
        wishlistAdapter.bindProducts(products)
    }

    private fun handleLoading() {
        viewBinding.loadingView.isVisible = true
        viewBinding.successView.isVisible = false
    }


}