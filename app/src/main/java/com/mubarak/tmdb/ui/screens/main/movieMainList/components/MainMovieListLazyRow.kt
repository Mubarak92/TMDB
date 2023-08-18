package com.mubarak.tmdb.ui.screens.main.movieMainList.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.ui.screens.destinations.DetailsScreenDestination
import com.mubarak.tmdb.ui.screens.main.movieMainList.MoviesListViewModel
import com.mubarak.tmdb.ui.screens.main.movieMainList.MovieListViewState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MainMovieListLazyRow(
    state: MovieListViewState?,
    navigator: DestinationsNavigator,
    viewModel: MoviesListViewModel,
    title:String
) {
    Text(modifier = Modifier.padding(start = 16.dp, top = 16.dp),text = title, fontWeight = FontWeight.Bold)
    LazyRow(
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
}
