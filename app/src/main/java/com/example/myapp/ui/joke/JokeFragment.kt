package com.example.myapp.ui.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp.databinding.FragmentJokeBinding
import com.example.myapp.repository.JokeRepository
import com.example.myapp.ui.joke.adapter.JokeAdapter

class JokeFragment : Fragment() {

    private lateinit var jokeViewModel: JokeViewModel
    private var _binding: FragmentJokeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val repository = JokeRepository()
        val jokeViewModelFactory = JokeViewModelFactory(repository)
        jokeViewModel = ViewModelProvider(this, jokeViewModelFactory).get(JokeViewModel::class.java)
        _binding = FragmentJokeBinding.inflate(inflater, container, false)
        loadJokes()
        return binding.root
    }


    private fun loadJokes() {
        val recyclerView = binding.jokeRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.reload.setOnClickListener {
            countJokes()
            jokeViewModel.myResponse.observe(viewLifecycleOwner) { response ->
                if (response.isSuccessful) {
                    try {
                        recyclerView.adapter = jokeViewModel.myResponse.value?.body()?.let { it ->
                            JokeAdapter(
                                it.jokes)
                    }
                    } catch (e: Exception) {
                        Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun countJokes() {
        try {
            jokeViewModel.getResult(binding.count.text.toString().toInt())
        } catch (e: Exception) {
            Toast.makeText(requireContext(), "Введите корректные данные", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}