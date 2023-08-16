package com.mubarak.tmdb.ui.screens.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.components.DetailsCard
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailsScreen(
    id: Int,
    movieId: Int,
    movieName: String?,
    pathType:String,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(null) {
        viewModel.getMovieDetails(movieId = movieId, pathType = pathType)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        DetailsCard(
            posterPath = state?.posterPath,
            movieTitle = state?.title ?: state?.originalTitle ?: "-",
            backgroundPoster = state?.backdropPath
        )
    }
}