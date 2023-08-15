package com.mubarak.tmdb.ui.screens.main.components

import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.mubarak.tmdb.data.network.Constant.BASE_POSTER_URL

@Composable
fun MovieCard(
    movieTitle: String?,
    posterPath: String?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(16.dp)
            .clickable {
                Toast
                    .makeText(context, "$movieTitle", LENGTH_SHORT)
                    .show()
            }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SubcomposeAsyncImage(
                modifier = modifier,
                model = BASE_POSTER_URL + posterPath,
                loading = { CircularProgressIndicator() },
                contentDescription = "poster",
                // placeholder = painterResource(id = R.drawable.full_logo),
                // error = painterResource(id = R.drawable.ic_broken_image)
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