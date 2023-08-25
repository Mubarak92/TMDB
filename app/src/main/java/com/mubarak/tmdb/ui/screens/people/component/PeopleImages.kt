package com.mubarak.tmdb.ui.screens.people.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.R
import com.mubarak.tmdb.data.network.Constant
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun PeopleImages(
    personImageUrl: String?,
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(300.dp)
            .padding(8.dp)

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val imageUrl = Constant.BASE_POSTER_URL + personImageUrl

            CoilImage(
                previewPlaceholder = R.drawable.ic_broken_image,
                imageModel = { imageUrl },
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .height(240.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(4.dp)),
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
        }
    }
}