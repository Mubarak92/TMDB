package com.mubarak.tmdb.ui.screens.details

import androidx.compose.foundation.layout.Column
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
    Column {
        
        Text(text = movieName.toString())
        Text(text = movieId.toString())
    }
}