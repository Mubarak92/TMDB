package com.mubarak.tmdb.ui.screens.main.movieMainList

import com.mubarak.tmdb.data.domain.model.MovieItem

data class MovieListViewState(
    val isLoading: Boolean = false,
    val data: List<MovieItem>? = null,
    val error: Boolean = false
)