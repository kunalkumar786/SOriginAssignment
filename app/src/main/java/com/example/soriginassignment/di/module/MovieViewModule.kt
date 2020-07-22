package com.example.soriginassignment.di.module

import android.app.Application

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.soriginassignment.model.Movie
import com.example.soriginassignment.repository.MainRepository
import com.example.soriginassignment.utility.NetworkHelper
import com.example.soriginassignment.utility.Resource
import kotlinx.coroutines.launch

class MovieViewModule(private val mainRepository: MainRepository,
                      private val networkHelper: NetworkHelper, application: Application
):ViewModel() {

    private val _movies = MutableLiveData<Resource<List<Movie>>>()
    val movies: LiveData<Resource<List<Movie>>>
        get() = _movies
/*init {
    fetchMovies()
}*/

    public fun fetchMovies(url:String):MutableLiveData<Resource<List<Movie>>> {
        viewModelScope.launch {
            _movies.postValue(Resource.loading(null))
            if (networkHelper.isNetworkConnected()) {
                mainRepository.getMovie().let {
                    if (it.isSuccessful) {
                        _movies.postValue(Resource.success(it.body()))
                    } else _movies.postValue(Resource.error(it.errorBody().toString(), null))
                }
            } else _movies.postValue(Resource.error("No internet connection", null))
        }
    return _movies
    }
}