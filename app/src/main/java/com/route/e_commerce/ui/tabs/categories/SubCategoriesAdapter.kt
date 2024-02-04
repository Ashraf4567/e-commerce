package com.route.e_commerce.ui.tabs.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.domain.module.SubCategory
import com.route.e_commerce.databinding.ItemSubCategoryBinding

class SubCategoriesAdapter(private var subCategoriesList: List<SubCategory?>?): RecyclerView.Adapter<SubCategoriesAdapter.ViewHolder>(){

    class ViewHolder(private val itemBinding: ItemSubCategoryBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(subCategory: SubCategory?){
            itemBinding.subCategory = subCategory
            itemBinding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewBinding = ItemSubCategoryBinding
            .inflate(LayoutInflater.from(parent.context), parent , false)
        return ViewHolder(viewBinding)
    }

    override fun getItemCount(): Int = subCategoriesList?.size?:0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val subCategory = subCategoriesList!![position]
        holder.bind(subCategory)
    }

    fun bindSubCategories(subCategoriesList: List<SubCategory?>?){
        this.subCategoriesList = subCategoriesList
        notifyDataSetChanged()
    }

}