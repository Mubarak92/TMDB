package com.mubarak.tmdb.ui.screens.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.ui.screens.dashboard.movieMainList.components.MovieCard
import com.mubarak.tmdb.ui.screens.destinations.DetailsScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {

    val favoriteUiState by viewModel.favoriteUiState.collectAsStateWithLifecycle()

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
                        MovieCard(
                            modifier = Modifier.clickable {
                                navigator.navigate(
                                    DetailsScreenDestination(
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