package com.route.data.model.wishlist

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.route.data.model.product.ProductDto


data class WishListResponse(

	@field:SerializedName("data")
	val data: List<ProductDto?>? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)






