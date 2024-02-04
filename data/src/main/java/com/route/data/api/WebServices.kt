package com.route.data.api

import com.route.data.model.cart.AddToCartResponseDto
import com.route.data.model.cart.CartResponse
import com.route.data.model.category.CategoryResponse
import com.route.data.model.product.AddProductToWishListResponseDto
import com.route.data.model.product.ProductResponse
import com.route.data.model.product.TestProductResponse
import com.route.data.model.signup.AuthResponse
import com.route.data.model.subCategory.SubCategoriesResponse
import com.route.data.model.wishlist.WishListResponse
import com.route.domain.module.AddProductRequest
import com.route.domain.module.LoginRequest
import com.route.domain.module.SignupRequest
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface WebServices {
    @GET("api/v1/categories")
    suspend fun getAllCategories(): CategoryResponse

    @GET("api/v1/categories/{id}/subcategories")
    suspend fun getAllSubCategoriesById(@Path("id") id: String?): SubCategoriesResponse

    @GET("api/v1/products/{productId}")
    suspend fun getSpecificProduct(@Path("productId") productId: String): TestProductResponse

    @GET("api/v1/products")
    suspend fun getAllProducts(
        @Query("category[in]") categoryId: String = "6439d2d167d9aa4ca970649f"
    ): ProductResponse

    @POST("api/v1/auth/signup")
    suspend fun signUp(
        @Body signUpRequest: SignupRequest): AuthResponse

    @POST("api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest): AuthResponse

    @POST("api/v1/wishlist")
    suspend fun addProductToWishlist(
        @Body productId: AddProductRequest,
        @Header("token") token: String
    ): AddProductToWishListResponseDto

    @POST("api/v1/cart")
    suspend fun addToCart(
        @Body productId: AddProductRequest,
        @Header("token") token: String
    ): AddToCartResponseDto

    @DELETE("api/v1/cart/{productId}")
    suspend fun removeCartItem(@Path("productId") productId: String,
        @Header("token") token: String
    ): CartResponse

    @GET("api/v1/wishlist")
    suspend fun getWishList(@Header("token") token: String
    ): WishListResponse

    @GET("api/v1/cart")
    suspend fun getCart(@Header("token") token: String
    ): CartResponse

}