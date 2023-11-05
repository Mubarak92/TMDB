package com.mubarak.tmdb.ui.screens.dashboard.tvShows.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.dashboard.tvShows.main.components.MainTvShowsListLazyRow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun TvShowsScreen(
    navigator: DestinationsNavigator,
    viewModel: TvShowsViewModel = hiltViewModel(),

    ) {
    val airingTodayState by viewModel.airingTodayViewState.collectAsStateWithLifecycle()
    val onAirState by viewModel.onAirViewState.collectAsStateWithLifecycle()
    val popularState by viewModel.popularViewState.collectAsStateWithLifecycle()
    val topRatedState by viewModel.topRatedViewState.collectAsStateWithLifecycle()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        MainTvShowsListLazyRow(airingTodayState?.airingTodayList.orEmpty(), navigator, "airingTodayList")
        MainTvShowsListLazyRow(onAirState?.onAirList.orEmpty(), navigator, "onAirList")
        MainTvShowsListLazyRow(popularState?.popularShowsList.orEmpty(), navigator, "popularShowsList")
        MainTvShowsListLazyRow(topRatedState?.topRatedList.orEmpty(), navigator, "topRatedList")
    }
}