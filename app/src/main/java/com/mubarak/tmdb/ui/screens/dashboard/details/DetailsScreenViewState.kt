package com.mubarak.tmdb.ui.screens.dashboard.details

import com.mubarak.tmdb.domain.model.movieModel.MovieDetailsItem

data class DetailsScreenViewState(
    val isLoading: Boolean = false,
    val data: MovieDetailsItem? = null,
    val error: Boolean = false
)