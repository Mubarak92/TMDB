package com.mubarak.tmdb.ui.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.main.components.MovieCard
import com.mubarak.tmdb.utils.ViewState
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailsScreen(
    id: Int,
    movieId: Int,
    movieName: String?,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    viewModel.getMovieDetails(movieId = movieId)
    Column {
        when (val screenState = state) {
            is ViewState.Success -> {

                MovieCard(
                    modifier = Modifier.clickable {},
                    posterPath = screenState.data.posterPath,
                    movieTitle = screenState.data.title ?: screenState.data.originalTitle ?: "-"
                )

//                LazyVerticalGrid(
//                    columns = GridCells.Fixed(2),
//                    content = {
//                        items(screenState.data) { item: DetailsItem ->
//                            MovieCard(
//                                modifier = Modifier.clickable {},
//                                posterPath = item.posterPath,
//                                movieTitle = item.title ?: item.name ?: item.originalTitle ?: "-"
//                            )
//                        }
//                    }
//                )
            }

            is ViewState.Error -> {
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

            is ViewState.Loading -> {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator()
                }
            }

        }
    }
}