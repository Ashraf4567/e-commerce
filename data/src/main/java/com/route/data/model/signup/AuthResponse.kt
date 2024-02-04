package com.route.data.model.signup

import com.google.gson.annotations.SerializedName
import com.route.domain.module.UserResponse

data class AuthResponse(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: UserDto? = null,

	@field:SerializedName("token")
	val token: String? = null
){
	fun mapToUser(): UserResponse {
		return UserResponse(
			name = user?.name,
			role = user?.role ,
			email = user?.email,
			token = token,
			statusMessage = message

		)
	}
}
