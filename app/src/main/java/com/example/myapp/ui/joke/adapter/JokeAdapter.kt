package com.example.myapp.ui.joke.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.data.Joke
import com.example.myapp.databinding.JokeItemBinding

class JokeAdapter(private var jokes: List<Joke>) : RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {


    class JokeViewHolder(val binding: JokeItemBinding): RecyclerView.ViewHolder(binding.root){

        companion object {
            fun from(parent: ViewGroup): JokeViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = JokeItemBinding.inflate(layoutInflater, parent, false)
                return JokeViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        return JokeViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return jokes.size
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.binding.joke.text = jokes[position].joke
    }
}
