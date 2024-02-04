package com.route.data.model.product


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

data class TestProductResponse(
    @SerializedName("data")
    val data: ProductDto?
)