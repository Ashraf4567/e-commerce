package com.route.data.api

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.route.data.repository.SessionManagerImpl
import com.route.domain.module.UserResponse
import com.route.domain.sessionManager.SessionManager
import com.route.domain.usecases.SignupUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {


    @Provides
    fun provideLoggingInterceptor():HttpLoggingInterceptor{
        val loggingInterceptor = HttpLoggingInterceptor {
                message -> Log.e("api", message ?:"") }

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }

    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("your_preference_name", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideTokenInterceptor(sharedPreferences: SharedPreferences): TokenInterceptor {
        val userDataJson = sharedPreferences.getString("user_data", null)
        val token= Gson().fromJson(userDataJson, UserResponse::class.java).token
        Log.d("test token" , token.toString())
        return TokenInterceptor(token?:"")
    }

    @Provides
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
        //tokenInterceptor: TokenInterceptor
    ):OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            //.addInterceptor(tokenInterceptor)
            .build()
    }

    @Provides
    fun provideGsonConvertorFactory():GsonConverterFactory{
        return GsonConverterFactory.create()
    }


        @Provides
        fun provideRetrofit(client: OkHttpClient,
        converter:GsonConverterFactory):Retrofit{
            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://ecommerce.routemisr.com/")
                .addConverterFactory(converter)
                .build()
        }
    @Provides
    fun provideWebServices(retrofit: Retrofit): WebServices {
        return retrofit.create(WebServices::class.java)
    }
}