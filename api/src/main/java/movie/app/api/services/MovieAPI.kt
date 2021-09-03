package movie.app.api.services

import movie.app.api.API_KEY
import movie.app.api.models.Movie
import movie.app.api.models.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {


    @GET("movie/379686")
    suspend fun getMovie(
        @Query("api_key") key: String? = API_KEY
    ): Response<Movie>

    @GET("movie/popular")
    suspend fun getMoviesResponse(
        @Query("api_key") key: String? = API_KEY
    ): Response<MoviesResponse>

}