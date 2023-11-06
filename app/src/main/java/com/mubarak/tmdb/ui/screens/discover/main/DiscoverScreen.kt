package com.mubarak.tmdb.ui.screens.discover.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.discover.main.components.DiscoverCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DiscoverScreen(
    navigator: DestinationsNavigator,
    ) {

    val list = listOf(
        (DiscoverListItems(stringResource(id = R.string.action), 28)),
        (DiscoverListItems(stringResource(id = R.string.adventure), 12)),
        (DiscoverListItems(stringResource(id = R.string.animation), 16)),
        (DiscoverListItems(stringResource(id = R.string.comedy), 35)),
        (DiscoverListItems(stringResource(id = R.string.crime), 80)),
        (DiscoverListItems(stringResource(id = R.string.documentary), 99)),
        (DiscoverListItems(stringResource(id = R.string.drama), 18)),
        (DiscoverListItems(stringResource(id = R.string.family), 10751)),
        (DiscoverListItems(stringResource(id = R.string.fantasy), 14)),
        (DiscoverListItems(stringResource(id = R.string.history), 36)),
        (DiscoverListItems(stringResource(id = R.string.horror), 27)),
        (DiscoverListItems(stringResource(id = R.string.music), 10402)),
        (DiscoverListItems(stringResource(id = R.string.mystery), 9648)),
        (DiscoverListItems(stringResource(id = R.string.romance), 10749)),
        (DiscoverListItems(stringResource(id = R.string.science_fiction), 878)),
        (DiscoverListItems(stringResource(id = R.string.thriller), 53)),
        (DiscoverListItems(stringResource(id = R.string.war), 37))
    )

    LazyColumn(content = {
        items(list) { item ->
            DiscoverCard(title = item.name, genres = item.id, navigator = navigator)
        }
    })

}