package com.example.soriginassignment.repository

import com.example.soriginassignment.network.ApiHelper

class MainRepository(private val apiHelper:ApiHelper) {
    suspend fun getMovie()=apiHelper.getMovie()
}