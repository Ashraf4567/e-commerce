package com.route.data.model.cart

import com.google.gson.annotations.SerializedName
import com.route.data.model.product.ProductDto
import com.route.domain.module.Cart
import com.route.domain.module.Product

data class CartResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("numOfCartItems")
	val numOfCartItems: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
)



data class Data(

	@field:SerializedName("cartOwner")
	val cartOwner: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("totalCartPrice")
	val totalCartPrice: Int? = null,

	@field:SerializedName("__v")
	val v: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("products")
	val products: List<ProductsItem?>? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
){
	fun mapToCartResponse(): Cart{
		return Cart(
			totalCartPrice = totalCartPrice,
			numOfCartItems = products?.size,
			products = products?.map {
				it?.mapToDomain()
			}
		)
	}
}

data class ProductsItem(

	@field:SerializedName("product")
	val product: ProductDto? = null,

	@field:SerializedName("price")
	val price: Int? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("_id")
	val id: String? = null
){
	fun mapToDomain(): Product {
		return Product(
			title = product?.title,
			id =  id,
			price = price,
			imageCover = product?.imageCover
		)
	}
}



