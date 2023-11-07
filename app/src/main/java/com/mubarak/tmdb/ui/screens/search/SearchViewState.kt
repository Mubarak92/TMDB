package com.mubarak.tmdb.ui.screens.search

import com.mubarak.tmdb.domain.model.movieModel.MovieItem

data class SearchViewState(
    val isLoading: Boolean = false,
    val data: List<MovieItem>? = null,
    val error: Boolean = false
)