package com.route.e_commerce.ui.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.route.e_commerce.databinding.FragmentCartBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CartFragment : Fragment() {

    private val viewModel: CartViewModel by viewModels()
    lateinit var viewBinding: FragmentCartBinding
     private var cartAdapter = CartAdapter()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = FragmentCartBinding.inflate(inflater , container , false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.cartRecycler.adapter = cartAdapter

        cartAdapter.onRemoveProductClickListener = CartAdapter.OnProductClickListener{id, position ->
            cartAdapter.notifyItemRemoved(position)
            viewModel.removeCartItem(id)
        }

        lifecycleScope.launch {
            viewModel.productsStateFlow.collect{
                cartAdapter.submitList(it?.products)
                Log.d("cart test" , it?.products?.get(1)?.title.toString())
                viewBinding.totalPriceTv.text = "EGP ${it?.totalCartPrice.toString()}"
            }

        }
    }

}