package com.mubarak.tmdb.ui.screens.favorite

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.ui.screens.dashboard.movies.main.components.MovieCard
import com.mubarak.tmdb.ui.screens.destinations.MoviesDetailsScreenDestination
import com.mubarak.tmdb.ui.screens.favorite.components.DeleteDialog
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalFoundationApi::class)
@Destination
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val favoriteUiState by viewModel.favoriteUiState.collectAsStateWithLifecycle()
    val openAlertDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (favoriteUiState.itemList.isNotEmpty()) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(favoriteUiState.itemList) { item: MovieItem ->
                        if (openAlertDialog.value){
                            DeleteDialog(
                                onDismissRequest = { openAlertDialog.value = false },
                                onConfirmation = {
                                    openAlertDialog.value = false
                                },
                                dialogTitle = "Delete?",
                                dialogText = "Are you sure you want to delete ( ${item.title} ) from your favorites?",
                                icon = Icons.Default.Info,
                                movieItem = item
                            )
                        }
                        MovieCard(
                            modifier = Modifier.combinedClickable(
                                onLongClick = { openAlertDialog.value = true }
                            ) {
                                navigator.navigate(
                                    MoviesDetailsScreenDestination(
                                        movieItem = item
                                    )
                                )
                            },
                            posterPath = item.posterPath,
                            movieTitle = item.title ?: item.name ?: item.originalTitle ?: "-"
                        )
                    }
                }
            )
        } else {
            Text(text = "You don't have any favorite yet", fontWeight = FontWeight.Bold)
        }
    }
}