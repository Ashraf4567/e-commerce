package com.route.domain.module

import kotlinx.parcelize.Parcelize
import android.os.Parcelable


@Parcelize
data class Cart(
	val cartOwner: String? = null,
	val createdAt: String? = null,
	val totalCartPrice: Int? = null,
	val v: Int? = null,
	val id: String? = null,
	val products: List<Product?>? = null,
	val updatedAt: String? = null,
	val numOfCartItems: Int? = null,
) : Parcelable


