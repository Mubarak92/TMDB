package com.mubarak.tmdb.ui.screens.dashboard.tvShows.main.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.tmdb.domain.model.tvShowsModel.TvShowsItem
import com.mubarak.tmdb.ui.screens.dashboard.movies.main.components.MovieCard
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun MainTvShowsListLazyRow(
    state: List<TvShowsItem>,
    navigator: DestinationsNavigator,
    title: String,
) {

    Column {
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp),
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        }
        LazyRow {
            items(state) { item: TvShowsItem ->
                MovieCard(
                    posterPath = item.posterPath,
                    movieTitle = item.name
                )
            }
        }
    }
}
