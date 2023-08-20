package com.mubarak.tmdb.ui.screens.dashboard.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsCard
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsTopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailsScreen(
    id: Int,
    movieId: Int?,
    movieTitle: String?,
    pathType: String,
    viewModel: DetailsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(null) {
        viewModel.getMovieDetails(movieId = movieId, pathType = pathType)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        DetailsTopBar(movieTitle, navigator)

        Column(modifier = Modifier.fillMaxSize()) {
            DetailsCard(
                posterPath = state?.data?.posterPath,
                movieTitle = state?.data?.title ?: state?.data?.originalTitle ?: "-",
                backgroundPoster = state?.data?.backdropPath
            )
        }
    }
}