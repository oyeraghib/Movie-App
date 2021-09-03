package movie.app.api

import movie.app.api.services.MovieAPI
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


const val API_KEY = "ce14627836985b759f9d5bf25fbaa6ab"
const val BASE_URL = "https://api.themoviedb.org/3/"


object MovieClient {

private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val api = retrofit.create(MovieAPI::class.java)



}
