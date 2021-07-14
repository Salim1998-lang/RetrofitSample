package com.example.myapp.ui.joke

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.Result
import com.example.myapp.repository.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class JokeViewModel(private val repository: JokeRepository) : ViewModel() {

    val myResponse: MutableLiveData<Response<Result>> = MutableLiveData()

    fun getResult(countJokes: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getResult(countJokes)
            myResponse.postValue(response)
        }
    }
}