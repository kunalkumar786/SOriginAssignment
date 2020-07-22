package com.example.soriginassignment.network

import com.example.soriginassignment.model.Movie
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
@GET
suspend fun getMovie(@Url url:String):Response<List<Movie>>

}