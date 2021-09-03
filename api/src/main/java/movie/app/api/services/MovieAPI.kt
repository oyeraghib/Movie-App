package movie.app.api.services

import movie.app.api.models.responses.Movie
import movie.app.api.models.responses.MoviesResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {


    @GET("movie/379686")
    suspend fun getMovie(
        @Query("api_key") key: String? = null
    ): Response<Movie>

    @GET("movie/popular")
    suspend fun getMoviesResponse(
        @Query("api_key") key: String? = null
    ): Response<MoviesResponse>

}