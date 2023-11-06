package com.mubarak.tmdb.ui.screens.dashboard.tvShows.main

import com.mubarak.tmdb.domain.model.tvShowsModel.TvShowsItem

data class TvShowsAiringTodayViewState(
    val isLoading: Boolean = false,
    val airingTodayList: List<TvShowsItem>? = null,
    val error: Boolean = false
)

data class TvShowsOnAirViewState(
    val isLoading: Boolean = false,
    val onAirList: List<TvShowsItem>? = null,
    val error: Boolean = false
)

data class TvShowsPopularViewState(
    val isLoading: Boolean = false,
    val popularShowsList: List<TvShowsItem>? = null,
    val error: Boolean = false
)

data class TvShowsTopRatedViewState(
    val isLoading: Boolean = false,
    val topRatedList: List<TvShowsItem>? = null,
    val error: Boolean = false
)