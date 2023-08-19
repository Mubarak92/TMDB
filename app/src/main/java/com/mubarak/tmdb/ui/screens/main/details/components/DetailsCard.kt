package com.mubarak.tmdb.ui.screens.main.details.components

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant
import com.skydoves.landscapist.animation.crossfade.CrossfadePlugin
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.components.rememberImageComponent
import com.skydoves.landscapist.palette.PalettePlugin
import com.skydoves.landscapist.palette.rememberPaletteState
import com.skydoves.landscapist.transformation.blur.BlurTransformationPlugin

@Composable
fun DetailsCard(
    movieTitle: String?,
    posterPath: String?,
    backgroundPoster: String?,
    modifier: Modifier = Modifier
) {
    var palette by rememberPaletteState(null)

    Box {

        Crossfade(
            targetState = palette,
            modifier = Modifier
                .fillMaxSize()
                .size(45.dp), label = ""
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.2f)
                    .background(color = Color(it?.lightVibrantSwatch?.rgb ?: 0))
                    .fillMaxSize()
            )
        }

        Box(Modifier.fillMaxWidth()) {
            val backGroundImageUrl = Constant.BASE_POSTER_URL + backgroundPoster

            CoilImage(
                imageModel = { backGroundImageUrl },
                previewPlaceholder = R.drawable.ic_broken_image,
                modifier = modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .alpha(0.2f),
                component = rememberImageComponent {
                    +BlurTransformationPlugin(radius = 5)
                    +CrossfadePlugin(duration = 550)
                },
            )

            Row(Modifier.fillMaxWidth()) {

                val imageUrl = Constant.BASE_POSTER_URL + posterPath

                CoilImage(
                    imageModel = { imageUrl },
                    previewPlaceholder = R.drawable.full_logo,
                    modifier = modifier
                        .height(300.dp)
                        .width(200.dp)
                        .padding(start = 16.dp, top = 16.dp),
                    component = rememberImageComponent {
                        +PalettePlugin { palette = it }
                    },
                    // shows an indicator while loading an image.
                    loading = {
                        Box(modifier = Modifier.matchParentSize()) {
                            CircularProgressIndicator(
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                    },
                )

                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween) {
                    Text(text = "Title")
                    Text(text = "Title")
                    Text(text = "Title")
                    Text(text = "TitleTitleTitleTitleTitle")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewDetailsCard() {
    DetailsCard("Title", "", "")
}