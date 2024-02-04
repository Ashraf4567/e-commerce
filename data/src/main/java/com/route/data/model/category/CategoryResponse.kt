package com.route.data.model.category

import com.google.gson.annotations.SerializedName
import com.route.data.model.Metadata

data class CategoryResponse(

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<CategoryDto?>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)