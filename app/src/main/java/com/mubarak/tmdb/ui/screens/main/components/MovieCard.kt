package com.mubarak.tmdb.ui.screens.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant.BASE_POSTER_URL

@Composable
fun MovieCard(
    movieTitle: String?,
    posterPath: String?,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = Modifier
            .background(Color.White)
            .padding(20.dp)
    ) {
        Column(modifier = Modifier.height(300.dp).width(300.dp)) {
            AsyncImage(
                modifier = modifier,
                model = BASE_POSTER_URL + posterPath,
                contentDescription = "poster",
                placeholder = painterResource(id = R.drawable.full_logo),
                error = painterResource(id = R.drawable.ic_broken_image)
            )
            Text(text = movieTitle ?: "-")
        }
    }
}
