package com.mubarak.tmdb.ui.screens.main.movieMainList.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.destinations.SearchScreenDestination
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightGreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun TopBar(
    navigator: DestinationsNavigator,
    ){

    TopAppBar(
        backgroundColor = DarkBlue,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(

                    painter = rememberAsyncImagePainter(com.google.android.material.R.drawable.ic_search_black_24),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clickable {
                           navigator.navigate(SearchScreenDestination)
                        }
                        .padding(horizontal = 8.dp),
                    tint = LightGreen
                )

                Image(
                    painter = rememberAsyncImagePainter(R.drawable.ic_tmdb_short_logo),
                    contentDescription = "Image",
                    modifier = Modifier
                        .width(120.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    )
}