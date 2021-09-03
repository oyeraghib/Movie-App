package movie.app.api

import movie.app.api.models.responses.Movie
import movie.app.api.services.MovieAPI
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


const val API_KEY = "ce14627836985b759f9d5bf25fbaa6ab"
const val BASE_URL = "https://api.themoviedb.org/3/"


object MovieClient {

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .build()

    val api = retrofit.create(MovieAPI::class.java)

}