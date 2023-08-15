package com.mubarak.tmdb.ui.screens.details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun DetailsScreen(
    id: Int,
    movieId:Int?,
    movieName:String?
) {

    Text(text = movieName.toString())
}