package com.example.myapp.data.network

import com.example.myapp.data.Result
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JokeApi {

    @GET("jokes/random/{jokesCount}")
    suspend fun getJokes(
        @Path("jokesCount") jokesCount: Int
    ): Response<Result>
}