package com.example.movieapp.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.movieapp.databinding.ListItemMoviesBinding
import movie.app.api.models.Movie

class MovieListRecyclerAdapter() :
    ListAdapter<Movie, MovieListRecyclerAdapter.MovieListViewHolder>(MovieListDiffCallback()) {

    class MovieListViewHolder(val binding: ListItemMoviesBinding): RecyclerView.ViewHolder(binding.root)

    class MovieListDiffCallback: DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem === newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {

        val inflater: LayoutInflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemMoviesBinding.inflate(inflater, parent, false)

        return MovieListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {

        val movie = getItem(position)
        holder.binding.tvMovieTitle.text =movie.title
        holder.binding.ivMoviePoster.load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2/${movie.posterPath}")
    }
}