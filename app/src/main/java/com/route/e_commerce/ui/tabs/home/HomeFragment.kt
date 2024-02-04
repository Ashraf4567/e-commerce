package com.route.e_commerce.ui.tabs.home

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.route.e_commerce.R

import com.route.e_commerce.databinding.FragmentHomeBinding
import com.route.e_commerce.model.Image
import com.route.e_commerce.ui.productScreen.ProductDetailsActivity
import com.route.e_commerce.ui.sharedViewModels.ProductViewModel
import com.route.e_commerce.util.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var viewBinding:FragmentHomeBinding
    private lateinit var viewPager: ViewPager2
    private val viewModelHome: HomeViewModel by viewModels()
    private val sharedViewModel: ProductViewModel by activityViewModels()
    private var categoriesHomeAdapter = CategoriesHomeAdapter(null)
    private var productHomeAdapter = ProductsHomeAdapter(mutableListOf())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("creation test","home fragment is created")
        viewBinding= FragmentHomeBinding.inflate(inflater,container,false)
        return viewBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        setUpOffers()
        initObservers()
    }

    private fun initViews() {
        viewBinding.categoriesRecycler.adapter = categoriesHomeAdapter
        viewBinding.productsAdapter.adapter = productHomeAdapter

        productHomeAdapter.onProductClickListener = ProductsHomeAdapter.OnProductClickListener { id ->
            val intent = Intent(requireActivity() , ProductDetailsActivity::class.java).apply {
                putExtra(Constants.PRODUCT_ID , id)
                startActivity(this)
            }
        }
        productHomeAdapter.onAddToCartClick = ProductsHomeAdapter.OnProductClickListener {id->
            sharedViewModel.addToCart(id)
        }
        productHomeAdapter.onAddToWishlistClick = ProductsHomeAdapter.OnProductClickListener { id->
            sharedViewModel.addToWishlist(id)
        }

        viewBinding.icCart.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_cartFragment)

        }

    }

    private fun initObservers() {
        viewModelHome.categoriesLiveData.observe(viewLifecycleOwner){
            categoriesHomeAdapter.bindCategories(it)
        }
        viewModelHome.productsLiveData.observe(viewLifecycleOwner){
            productHomeAdapter.bindProducts(it)
        }
        sharedViewModel.testAdd.observe(viewLifecycleOwner){
            Toast.makeText(activity , it , Toast.LENGTH_LONG).show()
        }
    }

    private fun setUpOffers() {
        viewPager = viewBinding.viewPager

        val images = listOf(
            Image(R.drawable.offer1),
            Image(R.drawable.offer2),
            Image(R.drawable.offer3)
        )

        val offersAdapter = OffersAdapter(images)
        viewPager.adapter = offersAdapter

        // Set up auto-scrolling
        val handler = Handler(Looper.getMainLooper())
        val runnable = Runnable {
            viewPager.currentItem = (viewPager.currentItem + 1) % images.size
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 3000) // Adjust the delay as needed
            }
        })

        // Start auto-scrolling
        handler.postDelayed(runnable, 3000)
    }

}