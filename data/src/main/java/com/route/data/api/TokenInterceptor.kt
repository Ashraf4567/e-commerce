package com.route.data.api

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val token: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestWithToken = originalRequest.newBuilder()
            .addHeader("token", token) // Add your token header here
            .build()

        return chain.proceed(requestWithToken)
    }
}