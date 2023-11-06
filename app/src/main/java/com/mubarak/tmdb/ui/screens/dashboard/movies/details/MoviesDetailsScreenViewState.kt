package com.mubarak.tmdb.ui.screens.dashboard.movies.details

import com.mubarak.tmdb.domain.model.movieModel.MovieDetailsItem

data class MoviesDetailsScreenViewState(
    val isLoading: Boolean = false,
    val data: MovieDetailsItem? = null,
    val error: Boolean = false
)