package com.mubarak.tmdb.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey
    val id: Int? = null,
    val title: String? = null,
    val originalTitle: String? = null,
    val posterPath: String? = null,
)
