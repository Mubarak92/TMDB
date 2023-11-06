package com.mubarak.tmdb.ui.screens.dashboard.moviesMainScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.dashboard.mainScreen.MoviesListViewModel
import com.mubarak.tmdb.ui.screens.dashboard.mainScreen.components.MainMovieListLazyRow
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun MoviesScreen(
    navigator: DestinationsNavigator,
    viewModel: MoviesListViewModel = hiltViewModel()
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())) {
        MainMovieListLazyRow(state, navigator, stringResource(id = R.string.trending_now), false)
        MainMovieListLazyRow(state, navigator, stringResource(id = R.string.whats_new), true)
    }
}