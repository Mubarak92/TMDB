package com.mubarak.tmdb.ui.screens.main.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant.BASE_POSTER_URL
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MovieCard(
    movieTitle: String?,
    posterPath: String?,
    modifier: Modifier = Modifier
) {

    Card(
        modifier = modifier
            .width(210.dp)
            .height(280.dp)
            .padding(12.dp)
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imageUrl = BASE_POSTER_URL + posterPath
            CoilImage(
                imageModel = { imageUrl },
                modifier = modifier,
                // shows an indicator while loading an image.
                loading = {
                    Box(modifier = Modifier.matchParentSize()) {
                        CircularProgressIndicator(
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                },
                // shows an error text if fail to load an image.
                failure = {
                    painterResource(id = R.drawable.ic_broken_image)
                    Text(text = "image request failed.")
                }
            )
            Text(maxLines = 2, text = movieTitle ?: "-", modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview
@Composable
fun previewCard() {
    MovieCard(
        "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA",
        "https://image.tmdb.org/t/p/w200/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg"
    )
}