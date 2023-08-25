package com.mubarak.tmdb.ui.screens.people.details

import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleSocial
import com.mubarak.tmdb.data.network.model.apiPeopleModel.CastItem
import com.mubarak.tmdb.domain.model.peopleModel.PeopleDetailsModel
import com.mubarak.tmdb.domain.model.peopleModel.PeopleImageItem

data class PeopleDetailsViewState(
    val isLoading: Boolean = false,
    val data: PeopleDetailsModel? = null,
    val error: Boolean = false,
    val error2: Throwable? = null,
)

data class PeopleImagesViewState(
    val isLoading: Boolean = false,
    val data: List<PeopleImageItem?>? = null,
    val error: Boolean = false,
    val error2: Throwable? = null,
)

data class PeopleMovieCreditsViewState(
    val isLoading: Boolean = false,
    val data: List<CastItem>? = null,
    val error: Boolean = false,
    val error2: Throwable? = null,
)

data class PeopleSocialMediaViewState(
    val isLoading: Boolean = false,
    val data: ApiPeopleSocial? = null,
    val error: Boolean = false,
    val error2: Throwable? = null,
)