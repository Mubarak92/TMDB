package com.mubarak.tmdb.ui.screens.main.details.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.google.android.material.R
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightGreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun DetailsTopBar(
    movieTitle: String?,
    navigator: DestinationsNavigator,
) {
    TopAppBar(
        backgroundColor = DarkBlue,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = rememberAsyncImagePainter(R.drawable.ic_arrow_back_black_24),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clickable {
                            navigator.navigateUp()
                        }
                        .padding(horizontal = 8.dp),
                    tint = LightGreen
                )

                if (movieTitle != null) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = movieTitle,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        color = LightGreen,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    )
}