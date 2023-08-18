package com.mubarak.tmdb.ui.screens.people

import com.mubarak.tmdb.data.domain.model.PeopleResultsItem

data class PeopleViewState(
    val isLoading: Boolean = false,
    val data: List<PeopleResultsItem>? = null,
    val error: Boolean = false
)
