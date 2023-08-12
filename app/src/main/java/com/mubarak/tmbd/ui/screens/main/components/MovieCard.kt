package com.mubarak.tmbd.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun MovieCard(
    posterPath : String = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg" ,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
) {
    Card(modifier = Modifier.background(Color.White)) {

        Box(contentAlignment = Alignment.TopEnd) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(modifier = modifier,
                    model = "https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg", contentDescription = "poster")
            }
//            AsyncImage(modifier = modifier,
//                    model = apiMovieItem.posterPath, contentDescription = "poster")
//            }

        }

    }

}

@Preview
@Composable
fun previewCard() {
    MovieCard("https://image.tmdb.org/t/p/original/8Vt6mWEReuy4Of61Lnj5Xj704m8.jpg")
}