package com.example.movieapp.data.repository

enum class Status{
    RUNNING,
    SUCCESS,
    FAILED
}

class NetworkState(val status: Status, val msg: String) {

    companion object{

        val LOADED: NetworkState
        val LOADING: NetworkState
        val ERROR: NetworkState

        init {

            LOADING = NetworkState(Status.RUNNING, "Running")
            LOADED = NetworkState(Status.SUCCESS, "Success")
            ERROR = NetworkState(Status.FAILED, "Something went wrong")

        }


    }
}