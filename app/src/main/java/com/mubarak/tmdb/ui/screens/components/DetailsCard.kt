package com.mubarak.tmdb.ui.screens.components

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.palette.graphics.Palette
import coil.compose.SubcomposeAsyncImage
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.ui.screens.main.components.TopBar

@Composable
fun DetailsCard(
    movieTitle: String?,
    posterPath: String?,
    backgroundPoster: String?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    /* Convert our Image Resource into a Bitmap */
    val bitmap = remember {
        BitmapFactory.decodeResource(context.resources, R.drawable.full_logo)
    }

    /* Create the Palette, pass the bitmap to it */
    val palette = remember {
        Palette.from(bitmap).generate()
    }

    TopBar()
    Box {

        Box(Modifier.fillMaxWidth()) {
            SubcomposeAsyncImage(
                modifier = modifier.fillMaxWidth(),
                model = Constant.BASE_POSTER_URL + backgroundPoster,
                contentDescription = "poster",
                alpha = 0.2f
                // placeholder = painterResource(id = R.drawable.full_logo),
                // error = painterResource(id = R.drawable.ic_broken_image)
            )
            Row() {
                SubcomposeAsyncImage(
                    modifier = modifier,
                    model = Constant.BASE_POSTER_URL + posterPath,
                    loading = { CircularProgressIndicator() },
                    contentDescription = "poster",
                    // placeholder = painterResource(id = R.drawable.full_logo),
                    // error = painterResource(id = R.drawable.ic_broken_image)
                )
                Column {
                    Text(text = "Title")
                    Text(text = "Title")
                    Text(text = "Title")
                    Text(text = "Title")                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailsCard() {
    // DetailsCard()
}