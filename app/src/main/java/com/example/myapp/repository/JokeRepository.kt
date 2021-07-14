package com.example.myapp.repository

import com.example.myapp.data.Result
import com.example.myapp.data.RetrofitInstance
import retrofit2.Response

class JokeRepository {

    suspend fun getResult(countJokes: Int): Response<Result> {
        return RetrofitInstance.api.getJokes(countJokes)
    }

}