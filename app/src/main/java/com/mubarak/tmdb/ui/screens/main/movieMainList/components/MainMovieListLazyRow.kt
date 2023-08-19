package com.mubarak.tmdb.ui.screens.main.movieMainList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.ui.screens.destinations.DetailsScreenDestination
import com.mubarak.tmdb.ui.screens.discover.DiscoverViewModel
import com.mubarak.tmdb.ui.screens.main.movieMainList.MoviesListViewModel
import com.mubarak.tmdb.ui.screens.main.movieMainList.MovieListViewState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MainMovieListLazyRow(
    state: MovieListViewState?,
    navigator: DestinationsNavigator,
    viewModel: MoviesListViewModel,
    title: String,
    hasScrollableTabs: Boolean
) {
    val isVisible by remember { mutableStateOf(hasScrollableTabs) }

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

             ScrollableTextTabComponent(isVisible)
        }
        LazyRow(
            content = {
                items(state?.data.orEmpty()) { item: MovieItem ->
                    MovieCard(
                        modifier = Modifier.clickable {
                            navigator.navigate(
                                DetailsScreenDestination(
                                    id = 1,
                                    movieTitle = item.originalTitle,
                                    movieId = item.id,
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
    }
}
