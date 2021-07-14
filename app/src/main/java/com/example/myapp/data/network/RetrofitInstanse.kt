package com.example.myapp.data

import com.example.myapp.data.network.JokeApi
import com.example.myapp.data.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: JokeApi by lazy {
        retrofit.create(JokeApi::class.java)
    }
}