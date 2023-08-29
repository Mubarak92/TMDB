package com.mubarak.tmdb.ui.screens.dashboard.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsCard
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsTopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.math.roundToInt

@Destination
@Composable
fun DetailsScreen(
    movieItem: MovieItem,
    viewModel: DetailsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(null) {
        viewModel.getMovieDetails(movieId = movieItem.id)
    }

    Column(modifier = Modifier.fillMaxSize()) {

        DetailsTopBar(movieItem, navigator = navigator)

        Column(modifier = Modifier.fillMaxSize()) {
            val voteAverage = (state?.data?.voteAverage?.times(10))?.roundToInt()?.toFloat()


            DetailsCard(
                posterPath = state?.data?.posterPath,
                backgroundPoster = state?.data?.backdropPath,
                voteAverage = voteAverage,
                genreList = state?.data?.genres
            )

        }
    }
}