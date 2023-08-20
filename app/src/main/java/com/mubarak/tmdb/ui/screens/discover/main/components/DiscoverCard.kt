package com.mubarak.tmdb.ui.screens.discover.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.ui.screens.destinations.DiscoverDetailsScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun DiscoverCard(
    name: String,
    genres: Int,
    navigator: DestinationsNavigator,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                navigator.navigate(DiscoverDetailsScreenDestination(genres))
            }
    ) {
        Text(text = name, modifier = Modifier.padding(16.dp))
    }
}
