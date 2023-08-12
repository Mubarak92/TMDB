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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mubarak.tmbd.R
import com.mubarak.tmbd.data.network.Constant.BASE_POSTER_URL

@Composable
fun MovieCard(
    posterPath: String?,
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .height(160.dp)
) {
    Card(modifier = Modifier.background(Color.White)) {

        Box(contentAlignment = Alignment.TopEnd) {
            Column(modifier = Modifier.fillMaxSize()) {
                AsyncImage(
                    modifier = modifier,
                    model = BASE_POSTER_URL + posterPath,
                    contentDescription = "poster",
                    placeholder = painterResource(id = R.drawable.full_logo),
                    error = painterResource(id = R.drawable.ic_broken_image)
                )
            }
        }
    }
}
