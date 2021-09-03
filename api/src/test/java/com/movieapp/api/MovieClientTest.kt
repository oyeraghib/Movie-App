package com.movieapp.api

import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.runBlocking
import movie.app.api.MovieClient
import org.junit.Test

class MovieClientTest {

    class MovieClientTest{

        val api = MovieClient.api

        //test for movie
        @Test
        fun `get Movie`() {

            runBlocking {

                var movies = api.getMovie()
                assertNotNull(movies.body())

            }


        }

        @Test
        fun `get Movies Response`() {

            runBlocking {

                var movies = api.getMoviesResponse("ce14627836985b759f9d5bf25fbaa6ab")
                assertNotNull(movies.body())
            }

        }

    }

}