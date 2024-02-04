package com.route.data.model.product

import com.google.gson.annotations.SerializedName
import com.route.domain.module.Category
import com.route.domain.module.Product
import com.route.domain.module.SubCategory


data class ProductDto(

	@field:SerializedName("sold")
	val sold: Int? = null,

	@field:SerializedName("images")
	val images: List<String?>? = null,

	@field:SerializedName("quantity")
	val quantity: Int? = null,

	@field:SerializedName("imageCover")
	val imageCover: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("ratingsQuantity")
	val ratingsQuantity: Int? = null,

	@field:SerializedName("ratingsAverage")
	val ratingsAverage: Double? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("_id")
	val _id: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("subcategory")
	val subcategory: List<SubCategory?>? = null,

	@field:SerializedName("category")
	val category: Category? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null,

	@field:SerializedName("priceAfterDiscount")
	val priceAfterDiscount: Int? = null
){
	fun mapToProduct():Product{
		return Product(
			sold = sold,
			images = images,
			subcategory = subcategory,
			imageCover = imageCover,
			title = title,
			description = description,
			ratingsAverage = ratingsAverage,
			slug = slug,
			price = price,
			id = id,
			ratingsQuantity = ratingsQuantity
		)
	}
}