package com.example.movieapp.remote

import retrofit2.http.GET
import retrofit2.http.Query



interface MovieInterface {


    @GET
    suspend fun getAllMovies(

        @Query("s")s: String,
        @Query("page")page: Int,
        @Query("apikey")apiKey: String

    ):retrofit2.Response<com.example.movieapp.data.vo.MovieResponse>
}