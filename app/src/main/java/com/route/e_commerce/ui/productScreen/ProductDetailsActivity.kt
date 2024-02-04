package com.route.e_commerce.ui.productScreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.google.android.material.snackbar.Snackbar
import com.route.e_commerce.R
import com.route.e_commerce.databinding.ActivityProductDetailsBinding
import com.route.e_commerce.ui.sharedViewModels.ProductViewModel
import com.route.e_commerce.util.Constants
import com.route.e_commerce.util.ControlState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {

    private val viewModel : ProductViewModel by viewModels()
    lateinit var viewBinding: ActivityProductDetailsBinding
     var productId: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)


         productId = intent.getStringExtra(Constants.PRODUCT_ID).toString()
        Log.d("product response" , "the id is  ${productId.toString()}")

        viewModel.getProduct(productId)


        initObservers()

        initViews()


    }

    private fun initViews() {
        viewBinding.addWishList.setOnClickListener {
            Log.d("ProductDetailsTest" , "productId is $productId")
            viewModel.addToWishlist(productId)
        }

        viewBinding.addToCartBtn.setOnClickListener {
            viewModel.addToCart(productId)
        }
    }

    private fun initObservers() {

        lifecycleScope.launch {
            viewModel.productResData.collect{
                viewBinding.product = it
            }
        }

        viewModel.state.observe(this){
            when(it){
                ControlState.LOADING -> handleLoading()
                ControlState.ERROR -> TODO()
                ControlState.SUCCESS -> handleSuccess()
            }
        }

        viewModel.testAdd.observe(this){
            showSnackBar(it)
            viewBinding.addWishList.setIconResource(R.drawable.ic_add_to_wishlist_selected)
        }
    }

    private fun showSnackBar(message: String?) {
        Snackbar.make(viewBinding.root, message?:"", Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun handleSuccess() {
        viewBinding.loadingView.isVisible = false
        viewBinding.successView.isVisible = true
    }

    private fun handleLoading() {
        viewBinding.loadingView.isVisible = true
        viewBinding.successView.isVisible = false
    }

}