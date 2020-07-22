package com.example.soriginassignment.model

import com.squareup.moshi.Json

data class Movie(@Json(name="Title")
                 val Title:String="",
                 @Json(name="Year")
                 val Year:String="",
                 @Json(name="imdbID")
                 val imdbID:String="",
                 @Json(name="Type")
                 val Type:String="",
                @Json(name="Poster")
                val Poster:String=""
                 ) {
}