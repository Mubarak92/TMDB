package com.mubarak.tmdb.ui.screens.people.details

import com.mubarak.tmdb.data.domain.model.peopleModel.PeopleDetailsModel

data class PeopleDetailsViewState(
    val isLoading: Boolean = false,
    val data: PeopleDetailsModel? = null,
    val error: Boolean = false,
    val error2: Throwable? = null,
)