package com.mubarak.tmdb.ui.screens.dashboard.details.components

import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.mubarak.tmdb.R
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.ui.screens.dashboard.details.DetailsViewModel
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightGreen
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@Destination
@Composable
fun DetailsTopBar(
    movieItem: MovieItem?,
    navigator: DestinationsNavigator,
    viewModel: DetailsViewModel = hiltViewModel(),

    ) {
    val coroutineScope = rememberCoroutineScope()

    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            "I'm currently watching ${movieItem?.title} ,link : https://www.themoviedb.org/movie/${movieItem?.id}"
        )
        type = "text/plain"
    }
    val shareIntent = Intent.createChooser(sendIntent, null)
    val context = LocalContext.current


    TopAppBar(
        backgroundColor = DarkBlue,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(
                    painter = rememberAsyncImagePainter(R.drawable.ic_arrow_back),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clickable {
                           navigator.navigateUp()
                        },
                    tint = LightGreen
                )

                if (movieItem?.title != null) {
                    Text(
                        textAlign = TextAlign.Center,
                        text = movieItem.title,
                        modifier = Modifier
                            .width(280.dp)
                            .padding(horizontal = 16.dp),
                        color = LightGreen,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Icon(
                    painter = rememberAsyncImagePainter(R.drawable.ic_heart),
                    contentDescription = "favorite",
                    modifier = Modifier
                        .clickable {
                            coroutineScope.launch {

                                    viewModel.addToMyWatchlist(movieItem)

                            }
                        },
                    tint = LightGreen
                )

                Icon(
                    painter = rememberAsyncImagePainter(R.drawable.ic_share),
                    contentDescription = "share",
                    modifier = Modifier
                        .clickable {
                            context.startActivity(shareIntent)
                        },
                    tint = LightGreen
                )
            }
        }
    )
}