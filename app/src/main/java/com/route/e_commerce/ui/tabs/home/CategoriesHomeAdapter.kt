package com.route.e_commerce.ui.tabs.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.Category
import com.route.e_commerce.databinding.ItemCategoryHomeBinding

class CategoriesHomeAdapter(var categoriesList: List<Category?>?)
    : RecyclerView.Adapter<CategoriesHomeAdapter.ViewHolder>() {


    class ViewHolder(val itemBinding: ItemCategoryHomeBinding)
        :RecyclerView.ViewHolder(itemBinding.root){
            fun bind(category: Category?){
                itemBinding.category = category
                itemBinding.executePendingBindings()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemCategoryHomeBinding
            .inflate(LayoutInflater.from(parent.context) , parent,false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = categoriesList?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categoriesList!![position]
        holder.bind(item)
    }

    fun bindCategories(categories: List<Category?>?) {
        this.categoriesList = categories
        notifyDataSetChanged()

    }
}