package com.mubarak.tmdb.ui.screens.main.details

import com.mubarak.tmdb.data.domain.model.MovieDetailsItem

data class DetailsScreenViewState(
    val isLoading: Boolean = false,
    val data: MovieDetailsItem? = null,
    val error: Boolean = false
)