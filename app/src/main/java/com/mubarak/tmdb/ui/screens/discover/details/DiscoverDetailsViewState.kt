package com.mubarak.tmdb.ui.screens.discover.details

import com.mubarak.tmdb.data.domain.model.MovieItem

data class DiscoverDetailsViewState(
    val isLoading: Boolean = false,
    val data: List<MovieItem>? = null,
    val error: Boolean = false
)