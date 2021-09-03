package com.example.movieapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.movieapp.databinding.FragmentListMovieBinding

class MovieListFragment: Fragment() {

    private lateinit var binding: FragmentListMovieBinding

    private val fragmentListViewModel: MovieListViewModel by viewModels()

    private var movieListAdapter:
}