package com.mubarak.tmdb.ui.screens.dashboard.details

import com.mubarak.tmdb.data.local.entities.MovieEntity
import com.mubarak.tmdb.domain.model.movieModel.MovieDetailsItem

data class DetailsScreenViewState(
    val isLoading: Boolean = false,
    val data: MovieEntity? = null,
    val error: Boolean = false
)