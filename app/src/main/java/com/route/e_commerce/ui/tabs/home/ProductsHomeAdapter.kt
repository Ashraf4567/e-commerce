package com.route.e_commerce.ui.tabs.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.Product
import com.route.e_commerce.R
import com.route.e_commerce.databinding.ItemProductBinding

class ProductsHomeAdapter(var productsList: List<Product?>?): RecyclerView.Adapter<ProductsHomeAdapter.ViewHolder>() {

    class ViewHolder(val item: ItemProductBinding):RecyclerView.ViewHolder(item.root){
        fun bind(product: Product?){
            item.product = product
            item.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemProductBinding
            .inflate(LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = productsList?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productsList!![position]
        holder.bind(item)
        onProductClickListener.let {
            holder.item.productImage
                .setOnClickListener {
                onProductClickListener?.onProductClick(item?.id!!)
            }
        }
        onAddToCartClick.let {
            holder.item.addToCart.setOnClickListener {
                onAddToCartClick?.onProductClick(item?.id!!)
            }
        }

        onAddToWishlistClick.let {
            holder.item.addWishList.setOnClickListener {
                holder.item.addWishList.setImageResource(R.drawable.ic_add_to_wishlist_selected)
                onAddToWishlistClick?.onProductClick(item?.id!!)
            }
        }
    }

    var onAddToCartClick: OnProductClickListener? = null
    var onAddToWishlistClick: OnProductClickListener? = null
    var onProductClickListener: OnProductClickListener? = null

    fun interface OnProductClickListener{
        fun onProductClick(id: String)
    }

    fun bindProducts(list: List<Product?>?) {
        productsList = list
        notifyDataSetChanged()
    }



}