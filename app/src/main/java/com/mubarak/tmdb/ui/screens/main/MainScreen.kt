package com.mubarak.tmdb.ui.screens.main

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.ui.screens.main.components.MovieCard
import com.mubarak.tmdb.utils.ViewState

@Composable
fun MainScreen(viewModel: MoviesViewModel = hiltViewModel()) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()
    val context = LocalContext.current
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            backgroundColor = colorResource(id = R.color.darkBlue),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(
                        painter = rememberAsyncImagePainter(com.google.android.material.R.drawable.ic_search_black_24),
                        contentDescription = "Image",
                        modifier = Modifier.clickable {
                            Toast.makeText(context, "Search", LENGTH_SHORT).show()
                        }.padding(horizontal = 16.dp)
                    )

                    Image(
                        painter = rememberAsyncImagePainter(R.drawable.ic_tmdb_short_logo),
                        contentDescription = "Image",
                        modifier = Modifier.width(120.dp).padding(horizontal = 16.dp)
                    )
                }
            }
        )
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