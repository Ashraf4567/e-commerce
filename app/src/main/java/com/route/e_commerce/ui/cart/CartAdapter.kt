package com.route.e_commerce.ui.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.Product
import com.route.e_commerce.databinding.ItemCartBinding

class CartAdapter: ListAdapter<Product, CartAdapter.ViewHolder>(ProductDiffCallback()){

    class ViewHolder( val itemBinding: ItemCartBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Product?) {
            itemBinding.product = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = ItemCartBinding
            .inflate(LayoutInflater.from(parent.context) , parent , false)
        return ViewHolder(item)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(getItem(position))
        onRemoveProductClickListener.let {
            holder.itemBinding.removeBtn.setOnClickListener {
                onRemoveProductClickListener?.
                onProductClick(getItem(position).id.toString() , position)
            }
        }
    }

    var onRemoveProductClickListener: OnProductClickListener? = null
    fun interface OnProductClickListener{
        fun onProductClick(id: String , position: Int)
    }

    private class ProductDiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }
}