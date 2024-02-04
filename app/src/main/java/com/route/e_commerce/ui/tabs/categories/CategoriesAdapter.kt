package com.route.e_commerce.ui.tabs.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.Category
import com.route.e_commerce.R
import com.route.e_commerce.databinding.ItemCategoryListBinding

class CategoriesAdapter(private var categories: List<Category?>?): RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder(private val itemBinding: ItemCategoryListBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(category: Category? , isSelected: Boolean){
            itemBinding.category = category
            if (isSelected){
                itemBinding.selectionBar.visibility = View.VISIBLE
                itemBinding.root.setBackgroundColor(ContextCompat
                    .getColor(itemBinding.root.context , R.color.white))
            }
            else{
                itemBinding.selectionBar.visibility = View.INVISIBLE
                itemBinding.root.setBackgroundColor(ContextCompat
                    .getColor(itemBinding.root.context , R.color.transparent))
            }
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemCategoryListBinding
            .inflate(LayoutInflater.from(parent.context), parent , false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int  = categories?.size?:0

    private var selectedItemPosition = 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categories!![position] , selectedItemPosition == position)
        onItemClickListener.let {
            holder.itemView.setOnClickListener{
                notifyItemChanged(selectedItemPosition)
                selectedItemPosition = position
                notifyItemChanged(position)
                onItemClickListener?.onItemClick(position , categories!![position])
            }
        }
    }

    fun bindCategories(categories: List<Category?>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null
    fun interface OnItemClickListener{
        fun onItemClick(position: Int, item: Category?)
    }
}