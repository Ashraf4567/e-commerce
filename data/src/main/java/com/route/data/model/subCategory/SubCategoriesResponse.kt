package com.route.data.model.subCategory

import com.google.gson.annotations.SerializedName
import com.route.data.model.Metadata

data class SubCategoriesResponse(

    @field:SerializedName("metadata")
	val metadata: Metadata? = null,

    @field:SerializedName("data")
	val data: List<SubCategoryDto?>? = null,

    @field:SerializedName("results")
	val results: Int? = null
)