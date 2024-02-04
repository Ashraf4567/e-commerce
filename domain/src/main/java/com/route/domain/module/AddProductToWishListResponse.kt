package com.route.domain.module

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class AddProductToWishListResponse(
	val data: List<String?>? = null,
	val message: String? = null,
	val status: String? = null
) : Parcelable
