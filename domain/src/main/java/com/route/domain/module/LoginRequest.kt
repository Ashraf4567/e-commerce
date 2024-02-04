package com.route.domain.module

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class LoginRequest(
	val password: String? = null,
	val email: String? = null
) : Parcelable
