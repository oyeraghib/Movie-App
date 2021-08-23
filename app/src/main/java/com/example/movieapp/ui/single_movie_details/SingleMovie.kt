package com.example.movieapp.ui.single_movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.get
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.api.POSTER_BASE_URL
import com.example.movieapp.data.api.TheMovieDBClient
import com.example.movieapp.data.api.TheMovieDBInterface
import com.example.movieapp.data.repository.NetworkState
import com.example.movieapp.data.vo.MovieDetails
import com.example.movieapp.databinding.ActivitySingleMovieBinding
import java.text.NumberFormat
import java.util.*

class SingleMovie : AppCompatActivity() {

    private lateinit var viewModel: SingleMovieViewModel
    private lateinit var movieRepository: MovieDetailsRepository
    private lateinit var binding: ActivitySingleMovieBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySingleMovieBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val movieId: Int = intent.getIntExtra("id", 1)

        val apiService: TheMovieDBInterface = TheMovieDBClient.getClient()
        movieRepository = MovieDetailsRepository(apiService)

        viewModel = getViewModel(movieId)
        viewModel.movieDetails.observe(this, Observer {
           bindUi(it)
        })

        viewModel.movieDetailsNetworkState.observe(this, Observer {
            binding.progressBar.setVisibility(if (it == NetworkState.LOADING) View.VISIBLE else View.GONE)
            binding.textError.setVisibility( if(it == NetworkState.ERROR) View.VISIBLE else View.GONE)
        })
    }

    fun bindUi(it: MovieDetails){

        binding.movieTitle.setText(it.title)
        binding.movieTagline.setText(it.tagline)
        binding.movieReleaseDate.setText(it.releaseDate)
      //  binding.movieRating.setText(it.voteAverage.toString())
        binding.movieRuntime.setText(it.runtime.toString() + "minutes")

        val formatCurrency: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        binding.movieBudget.setText(formatCurrency.format(it.budget))
        binding.movieRevenue.setText(formatCurrency.format(it.revenue))

        //for poster of movie
        val moviePosterURL: String = POSTER_BASE_URL + it.posterPath
        Glide.with(this)
            .load(moviePosterURL)
            .into(binding.moviePoster)

    }


    private fun getViewModel(movieId: Int): SingleMovieViewModel {

        return ViewModelProviders.of(this, object: ViewModelProvider.Factory {

            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return SingleMovieViewModel(movieRepository, movieId) as T
            }

        }) [SingleMovieViewModel::class.java]

    }
}