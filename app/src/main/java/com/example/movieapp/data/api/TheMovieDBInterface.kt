package com.example.movieapp.data.api

import com.example.movieapp.data.vo.MovieDetails
import com.example.movieapp.data.vo.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieDBInterface {

    //https://api.themoviedb.org/3/movie/550?api_key=ce14627836985b759f9d5bf25fbaa6ab
    //https://api.themoviedb.org/3/movie/popular?api_key=ce14627836985b759f9d5bf25fbaa6ab&language=en-US
    //https://api.themoviedb.org/3/


    @GET("movie/popular")
    fun getPopularMovie(@Query("page")page: Int): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") id: Int): Single<MovieDetails>



}