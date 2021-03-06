package com.example.movieapp.data

import movie.app.api.MovieClient
import movie.app.api.models.Movie

class MovieListRepo {

    //instance of api
    val repo = MovieClient.api

    suspend fun getMovieList(): List<Movie>? {

        val response = repo.getMoviesResponse()
        return response.body()?.results
    }


}