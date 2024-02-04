package com.route.data.model.category

import com.google.gson.annotations.SerializedName
import com.route.domain.module.Category

data class CategoryDto(

//	CategoryDto of data layer
	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){
	fun mapToCategory() :Category{
	return Category(
			image=image,
			createdAt=createdAt,
			name=name,
			id=id,
			slug=slug,
			updatedAt=this.updatedAt)
	}
}