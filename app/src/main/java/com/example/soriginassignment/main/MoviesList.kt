package com.example.soriginassignment.main

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.soriginassignment.MainActivity
import com.example.soriginassignment.R


class MoviesList : AppCompatActivity() {
    private lateinit var toolbar:Toolbar

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
    //toolbar=findViewById(R.id.toolbar)
    setSupportActionBar(findViewById(R.id.toolbar))
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toolbar.setNavigationOnClickListener{
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()

        }

    }
}