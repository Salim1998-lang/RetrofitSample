package com.example.myapp.data

import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("value")
    val jokes: List<Joke>
)

data class Joke(

    @SerializedName("id")
    val id: Int,
    @SerializedName("joke")
    val joke: String

)