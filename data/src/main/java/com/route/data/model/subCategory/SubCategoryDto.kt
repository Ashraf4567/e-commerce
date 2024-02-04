package com.route.data.model.subCategory

import com.google.gson.annotations.SerializedName
import com.route.domain.module.SubCategory

data class SubCategoryDto(

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){
	fun toSubCategory(): SubCategory{
		return SubCategory(
			name = name,
			id = id,
			slug = slug
		)
	}
}