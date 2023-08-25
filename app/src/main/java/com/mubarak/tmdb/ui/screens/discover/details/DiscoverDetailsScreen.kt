package com.mubarak.tmdb.ui.screens.discover.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.ui.commen.TopBar
import com.mubarak.tmdb.ui.screens.dashboard.movieMainList.components.MovieCard
import com.mubarak.tmdb.ui.screens.dashboard.movieMainList.components.TabRowComponent
import com.mubarak.tmdb.ui.screens.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DiscoverDetailsScreen(
    discoverTitle:String,
    genres: Int,
    viewModel: DiscoverDetailsViewModel = hiltViewModel(),
    navigator: DestinationsNavigator,
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(null) {
        viewModel.getMovieList(genres = genres)
    }

    Column(Modifier.fillMaxSize()) {
        TopBar(navigator,hasSearchIcon = false,hasTitle = true, title = discoverTitle)

        TabRowComponent()

        Column(
            Modifier
                .fillMaxSize()
        ) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(state?.data.orEmpty()) { item: MovieItem ->
                        MovieCard(
                            modifier = Modifier.clickable {
                                navigator.navigate(
                                    DetailsScreenDestination(
                                        id = 2,
                                        movieId = item.id,
                                        movieTitle = item.title ?: item.originalTitle,
                                        pathType= "movie",

                                    )
                                )
                            },
                            posterPath = item.posterPath,
                            movieTitle = item.title ?: item.name ?: item.originalTitle ?: "-"
                        )
                    }
                }
            )


            if (state?.error == true) {
                Snackbar(modifier = Modifier.padding(4.dp),
                    action = {
                        Text(
                            text = "Try again",
                            modifier = Modifier.clickable {
                            })
                    }) {
                    Text("an error occurred")
                }
            }

            if (state?.isLoading == true) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}