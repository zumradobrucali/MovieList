package com.movielist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {


    private val _movieItem = MutableLiveData<List<Movie>>()
    val movieItem: LiveData<List<Movie>>
        get() = _movieItem

    private val _status = MutableLiveData<String>()
    val status: LiveData<String>
        get() = _status

    private val _navigateToSelectedMovie = MutableLiveData<Movie>()
    val navigateToSelectedMovie: LiveData<Movie>
        get() = _navigateToSelectedMovie


    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main )

    init {
        getMovieDetails()
    }

    private fun getMovieDetails() {

        coroutineScope.launch {
            val getMovieDeferred = MovieApi.retrofitService.getMovieList("movie", "green", "130f93f8")
            try {
                val listResult = getMovieDeferred.await().search
                if (listResult.isNotEmpty()) {
                    _movieItem.value = listResult
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }

    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }


    fun displayMovieDetails(movie: Movie) {
        _navigateToSelectedMovie.value = movie
    }

    fun displayMovieDetailsComplete() {
        _navigateToSelectedMovie.value = null
    }



}

