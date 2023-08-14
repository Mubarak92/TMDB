package com.mubarak.tmdb.ui.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.main.MoviesViewModel

@Composable
fun ScrollableTextTabComponent(
    viewModel: MoviesViewModel = hiltViewModel(),
) {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf(
        (ScrollableTabs(stringResource(id = R.string.action), 28)),
        (ScrollableTabs(stringResource(id = R.string.adventure), 12)),
        (ScrollableTabs(stringResource(id = R.string.animation), 16)),
        (ScrollableTabs(stringResource(id = R.string.comedy), 35)),
        (ScrollableTabs(stringResource(id = R.string.crime), 80)),
        (ScrollableTabs(stringResource(id = R.string.documentary), 99)),
        (ScrollableTabs(stringResource(id = R.string.drama), 18)),
        (ScrollableTabs(stringResource(id = R.string.family), 10751)),
        (ScrollableTabs(stringResource(id = R.string.fantasy), 14)),
        (ScrollableTabs(stringResource(id = R.string.history), 36)),
        (ScrollableTabs(stringResource(id = R.string.horror), 27)),
        (ScrollableTabs(stringResource(id = R.string.music), 10402)),
        (ScrollableTabs(stringResource(id = R.string.mystery), 9648)),
        (ScrollableTabs(stringResource(id = R.string.romance), 10749)),
        (ScrollableTabs(stringResource(id = R.string.science_fiction), 878)),
        (ScrollableTabs(stringResource(id = R.string.thriller), 53)),
        (ScrollableTabs(stringResource(id = R.string.war), 37)),

        )

    ScrollableTabRow(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        edgePadding = 8.dp,
        selectedTabIndex = selectedIndex
    ) {
        list.forEachIndexed { index, movieItem ->
            Tab(selected = selectedIndex == index,
                onClick = { selectedIndex = index

                    viewModel.getPopularMovies(genres = movieItem.id)},
                text = { Text(text = movieItem.name) }
            )
        }
    }
}

data class ScrollableTabs(val name: String, val id: Int)