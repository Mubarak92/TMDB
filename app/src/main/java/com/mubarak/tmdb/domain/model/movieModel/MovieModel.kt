package com.mubarak.tmdb.domain.model.movieModel

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "movies_table")
data class MovieItem(
    @PrimaryKey
    val id: Int,
    val overview: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val video: Boolean? = null,
    val title: String? = null,
    val name: String? = null,
   // val genreIds: List<Int?>? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null,
    val releaseDate: String? = null,
    val popularity: Double? = null,
    val voteAverage: Double? = null,
    val adult: Boolean? = null,
    val voteCount: Int? = null
) : Serializable