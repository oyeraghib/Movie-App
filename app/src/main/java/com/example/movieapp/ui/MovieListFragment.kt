package com.example.movieapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.FragmentListMovieBinding

class MovieListFragment: Fragment() {

    private val movieListViewModel: MovieListViewModel by viewModels()

    private lateinit var binding: FragmentListMovieBinding

    private var movieListAdapter = MovieListRecyclerAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieListViewModel.fetchMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentListMovieBinding.inflate(inflater, container, false)

        binding.rvList.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.rvList.adapter = movieListAdapter

        movieListViewModel.movies.observe({ lifecycle }) {
            movieListAdapter.submitList(it)
        }

        return binding.root
    }
}
