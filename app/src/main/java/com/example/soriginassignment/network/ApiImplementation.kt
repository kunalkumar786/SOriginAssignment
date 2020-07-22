package com.example.soriginassignment.network

import com.example.soriginassignment.model.Movie
import retrofit2.Response

class ApiImplementation(private val apiService:ApiService,private val dynamic_rul:String):ApiHelper {

    override suspend fun getMovie(): Response<List<Movie>> = apiService.getMovie(dynamic_rul)


}