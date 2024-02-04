package com.route.e_commerce.ui.tabs.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.Product
import com.route.e_commerce.databinding.ItemWishlistBinding

class WishlistAdapter(var productsList: List<Product?>?): RecyclerView.Adapter<WishlistAdapter.ViewHolder>() {

    class ViewHolder(private val itemBinding: ItemWishlistBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(item: Product?) {
            itemBinding.product = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemWishlistBinding.inflate(LayoutInflater.from(parent.context)
        ,parent , false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = productsList!![position]
        holder.bind(item)
        onProductClickListener.let {
            holder.itemView.setOnClickListener {
                onProductClickListener?.onProductClick(item?.id!!)
            }
        }

    }

    override fun getItemCount(): Int = productsList?.size?:0

    fun bindProducts(list: List<Product?>?) {
        productsList = list
        notifyDataSetChanged()

    }

    var onProductClickListener: OnProductClickListener? = null
    fun interface OnProductClickListener{
        fun onProductClick(id: String)
    }
}