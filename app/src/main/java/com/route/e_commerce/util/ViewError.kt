package com.route.e_commerce.util

data class ViewError(
    val message: String? = null,
    val throwable: Throwable? = null,
    val onTryAgainClickListener: OnTryAgainClickListener
)

fun interface OnTryAgainClickListener {
    fun onTryAgainClick()
}
