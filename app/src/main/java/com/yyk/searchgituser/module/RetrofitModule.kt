package com.yyk.searchgituser.module

import com.yyk.searchgituser.`interface`.SearchGitUserInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitModule {
    private const val BASE_URL:String = "https://api.github.com/"
    val service: SearchGitUserInterface

    init{
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        service = retrofit.create(SearchGitUserInterface::class.java)
    }
}