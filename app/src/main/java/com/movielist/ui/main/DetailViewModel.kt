package com.movielist.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DetailViewModel(@Suppress("UNUSED_PARAMETER") movie: Movie, app: Application) : AndroidViewModel(app)  {

    private val _selectedMovie = MutableLiveData<Movie>()
    val selectedMovie : LiveData<Movie>
        get() = _selectedMovie

    init {
        _selectedMovie.value = movie
    }
}