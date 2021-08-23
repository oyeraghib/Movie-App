package com.example.movieapp.data.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movieapp.data.api.FIRST_PAGE
import com.example.movieapp.data.api.TheMovieDBInterface
import com.example.movieapp.data.vo.Movie
import io.reactivex.disposables.CompositeDisposable

class MovieDataSource(private val movieDBInterface: TheMovieDBInterface,
    compositeDisposable: CompositeDisposable): PagingSource<Int, Movie>() {

    private var page = FIRST_PAGE
    val networkState: MutableLiveData<NetworkState> = MutableLiveData()

        override fun getRefreshKey(state: PagingState<Int, Movie>): Int? {
            TODO("Not yet implemented")
        }

        override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Movie> {
            TODO("Not yet implemented")
        }
    }