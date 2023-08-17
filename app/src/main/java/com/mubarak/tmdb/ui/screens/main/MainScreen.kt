package com.mubarak.tmdb.ui.screens.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.ui.screens.destinations.DetailsScreenDestination
import com.mubarak.tmdb.ui.screens.main.components.MovieCard
import com.mubarak.tmdb.ui.screens.main.components.TabRowComponent
import com.mubarak.tmdb.ui.screens.main.components.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    viewModel: MoviesListViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    LaunchedEffect(null){
        viewModel.getTrendingNow(language = "en-US", pathType = viewModel.currentType)
    }

    Column(Modifier.fillMaxSize()) {

        TopBar()
        TabRowComponent()

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(state?.data.orEmpty()) { item: MovieItem ->
                    MovieCard(
                        modifier = Modifier.clickable {
                            navigator.navigate(
                                DetailsScreenDestination(
                                    id = 1,
                                    movieTitle = item.originalTitle,
                                    movieId = item.id!!,
                                    pathType = viewModel.currentType,
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
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator()
            }
        }
    }
}
