package com.mubarak.tmdb.domain.model.tvShowsModel

import java.io.Serializable

data class TvShowsItem (
    val firstAirDate: String,
    val overview: String,
    val originalLanguage: String,
    val genreIds: List<Int>,
    val posterPath: String,
    val originCountry: List<String>,
    val backdropPath: String?,
    val originalName: String,
    val popularity: Double,
    val voteAverage: Double,
    val name: String,
    val id: Int,
    val adult: Boolean,
    val voteCount: Int
): Serializable