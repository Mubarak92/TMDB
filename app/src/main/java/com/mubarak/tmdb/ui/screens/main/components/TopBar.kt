package com.mubarak.tmdb.ui.screens.main.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.mubarak.tmdb.R

@Composable
fun TopBar(){
    val context = LocalContext.current

    TopAppBar(
        backgroundColor = colorResource(id = R.color.darkBlue),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(

                    painter = rememberAsyncImagePainter(com.google.android.material.R.drawable.ic_search_black_24),
                    contentDescription = "Image",
                    modifier = Modifier
                        .clickable {
                            Toast
                                .makeText(context, "Search", Toast.LENGTH_SHORT)
                                .show()
                        }
                        .padding(horizontal = 16.dp),
                    tint = colorResource(id = R.color.LightGreen)
                )

                Image(
                    painter = rememberAsyncImagePainter(R.drawable.ic_tmdb_short_logo),
                    contentDescription = "Image",
                    modifier = Modifier
                        .width(120.dp)
                        .padding(horizontal = 16.dp)
                )
            }
        }
    )
}