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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.ui.screens.main.components.ExpandableSearchView
import com.mubarak.tmdb.ui.screens.main.components.MovieCard
import com.mubarak.tmdb.ui.screens.main.components.ScrollableTextTabComponent
import com.mubarak.tmdb.utils.ViewState

@Composable
fun MainScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize()) {
        ExpandableSearchView(
            searchDisplay = "",
            onSearchDisplayChanged = {  },
            onSearchDisplayClosed = {  })

        ScrollableTextTabComponent()

        when (val screenState = state) {
            is ViewState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    content = {
                        items(screenState.data) { item: MovieItem ->
                            MovieCard(posterPath = item.posterPath, movieTitle = item.title)
                        }
                    }
                )
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