package com.mubarak.tmdb.ui.screens.dashboard.mainScreen

import com.mubarak.tmdb.domain.model.movieModel.MovieItem

data class MovieListViewState(
    val isLoading: Boolean = false,
    val data: List<MovieItem>? = null,
    val error: Boolean = false
)