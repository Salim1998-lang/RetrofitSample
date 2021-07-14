package com.example.myapp.ui.joke

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapp.repository.JokeRepository

class JokeViewModelFactory(
    private val repository: JokeRepository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return JokeViewModel(repository) as T
    }
}