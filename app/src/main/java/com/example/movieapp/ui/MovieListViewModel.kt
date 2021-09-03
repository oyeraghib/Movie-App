package com.example.movieapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapp.data.MovieListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import movie.app.api.models.Movie

class MovieListViewModel: ViewModel() {

    //instance of repo
    private val repo = MovieListRepo()

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>> = _movies

    fun fetchMovies() {
        viewModelScope.launch(Dispatchers.IO) {
                _movies.postValue(repo.getMovieList())
        }
    }
 }