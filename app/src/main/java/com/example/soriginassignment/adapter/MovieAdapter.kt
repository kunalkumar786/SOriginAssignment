package com.example.soriginassignment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.soriginassignment.R
import com.example.soriginassignment.model.Movie
import kotlinx.android.synthetic.main.movie_item.view.*
import java.lang.StringBuilder

class MoviesAdapter(
    private val movies: ArrayList<Movie>
) : RecyclerView.Adapter<MoviesAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            val movie_description=StringBuilder()
            movie_description.append(movie.Title)
            movie_description.append(" ")
            movie_description.append("(")
            movie_description.append(movie.Year)
            movie_description.append(")")
            itemView.tv_movie_title.text =movie_description.toString()
            itemView.tv_movie_year.text =movie.Year
            Glide.with(itemView.iv_movie_image.context)
                .load(movie.Poster)
                .into(itemView.iv_movie_image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item, parent,
                false
            )
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(movies[position])

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }
}