package com.mubarak.tmdb.ui.screens.people.main

import com.mubarak.tmdb.data.domain.model.peopleModel.PeopleResultsItem

data class PeopleViewState(
    val isLoading: Boolean = false,
    val data: List<PeopleResultsItem>? = null,
    val error: Boolean = false
)
