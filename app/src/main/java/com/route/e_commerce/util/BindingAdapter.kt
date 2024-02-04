package com.route.e_commerce.util

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputLayout
import com.route.e_commerce.R

@BindingAdapter("error")
 fun bindErrorOnTextInputLayout(textInputLayout: TextInputLayout, errorMessage: String?) {

    textInputLayout.error = errorMessage
    Log.d("test error" , "error received")
}

@BindingAdapter("url")
fun bindImageWithUrl(
    imageView: ImageView,
    url: String?
) {


    Glide.with(imageView)
        .load(url)
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(imageView)

}