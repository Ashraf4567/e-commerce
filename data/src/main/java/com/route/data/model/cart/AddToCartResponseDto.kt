package com.route.data.model.cart

import com.google.gson.annotations.SerializedName
import com.route.domain.module.AddToCartResponse

data class AddToCartResponseDto(

	@field:SerializedName("numOfCartItems")
	val numOfCartItems: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
){
	fun mapToAddToCartResponse(): AddToCartResponse{
		return AddToCartResponse(
			numOfCartItems = numOfCartItems ,
			message = message ,
			status = status
		)
	}
}


