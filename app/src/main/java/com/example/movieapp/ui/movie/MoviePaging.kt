package com.example.movieapp.ui.movie

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.vo.Movie
import com.example.movieapp.data.vo.MovieResponse
import com.example.movieapp.remote.MovieInterface
import com.example.movieapp.utils.Constants
import java.lang.Exception

class MoviePaging(val s: String, val movieInterface: MovieInterface):PagingSource<Int, Movie>() {


    override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state?.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1)?: anchorPage?.nextKey?.minus(1)
        }

    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {

        val page = params.key?:1

        return try {

            val data = movieInterface.getAllMovies(s, page, Constants.API_KEY)

            LoadResult.Page(
                data = data.body()?.Search!!,
                prevKey = if (page == 1)null else page - 1,
                nextKey = if(data.body()!!.Search?.isEmpty()!!)null else page + 1
            )

        } catch (e: Exception){
            LoadResult.Error(e)
        }


     }



}