package com.example.movieapp.data.api

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


const val FIRST_PAGE = 1
const val POST_PER_PAGE = 20

const val API_KEY = "ce14627836985b759f9d5bf25fbaa6ab"
const val BASE_URL = "https://developers.themoviedb.org/3/"
const val POSTER_BASE_URL = "https://image.tmdb.org/t/p/original"

//https://image.tmdb.org/t/p/original/or06FN3Dka5tukK1e9sl16pB3iy.jpg

object TheMovieDBClient {

    fun getClient(): TheMovieDBInterface {

        val requestInterceptor = Interceptor { chain ->
            //Interceptor takes only one argument which is a lambda function so parenthesis can be omitted

            val url: HttpUrl = chain.request()
                .url()
                .newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build()

            val request: Request = chain.request()
                .newBuilder()
                .url(url)
                .build()

            return@Interceptor chain.proceed(request)//explicitly returns a value from whit @annotation
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheMovieDBInterface::class.java)
    }

}