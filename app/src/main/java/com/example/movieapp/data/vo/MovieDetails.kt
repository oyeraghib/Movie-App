package com.example.movieapp.data.vo

data class MovieDetails(
    val homepage: String,
    val id: Int,
    val imdb_id: String,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val status: String,
    val tagline: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)