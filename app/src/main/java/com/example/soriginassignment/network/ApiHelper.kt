package com.example.soriginassignment.network

import com.example.soriginassignment.model.Movie
import retrofit2.Response

interface ApiHelper {
    suspend fun getMovie(): Response<List<Movie>>

}