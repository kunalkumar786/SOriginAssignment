package com.example.soriginassignment.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.soriginassignment.BuildConfig
import com.example.soriginassignment.R
import com.example.soriginassignment.adapter.MoviesAdapter
import com.example.soriginassignment.di.module.MovieViewModule
import com.example.soriginassignment.utility.Status
import org.koin.android.viewmodel.ext.android.viewModel


class SearchMovies : AppCompatActivity() {
    private val mainViewModel : MovieViewModule by viewModel()
    private lateinit var et_movie_name:EditText
    private lateinit var bt_submit:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        setupUI()

    }

    private fun setupUI() {
        et_movie_name=findViewById(R.id.et_movie_name)
        bt_submit=findViewById(R.id.bt_submit)
        val url=StringBuilder()
        url.append(BuildConfig.BASE_URL)
        url.append("?s=")
        url.append(et_movie_name.text.toString())
        url.append("&apiKey=")
        url.append(R.string.api_key)
        bt_submit.setOnClickListener {setupObserver(url.toString())}
    }

    private fun setupObserver(url:String) {
        mainViewModel.fetchMovies(url).observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {

                }
                Status.LOADING -> {

                }
                Status.ERROR -> {

                    Toast.makeText(this, it.msg, Toast.LENGTH_LONG).show()
                }
            }
        })
    }




}