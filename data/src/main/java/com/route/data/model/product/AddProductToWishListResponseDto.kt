package com.route.data.model.product

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.route.domain.module.AddProductToWishListResponse

@Parcelize
data class AddProductToWishListResponseDto(

	@field:SerializedName("data")
	val data: List<String?>? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable
{
	fun mapToAddProductResponse(): AddProductToWishListResponse{
		return AddProductToWishListResponse(
			data = data,
			message = message,
			status = status
		)
	}
}
