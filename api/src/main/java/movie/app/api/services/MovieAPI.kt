package movie.app.api.services

import movie.app.api.models.responses.Movie
import movie.app.api.models.responses.MoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {


    @GET("movie/379686")
    fun getMovie(
        @Query("api_key") key: String? = null
    ): Call<Movie>

    @GET("movie/popular")
    fun getMoviesResponse(
        @Query("api_key") key: String? = null
    ): Call<MoviesResponse>

}