package com.mubarak.tmdb.ui.commen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.destinations.SearchScreenDestination
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightGreen
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun TopBar(
    navigator: DestinationsNavigator,
    hasSearchIcon: Boolean = false,
    hasTitle: Boolean = false,
    title: String = ""
) {
    val isVisible by remember { mutableStateOf(hasSearchIcon) }
    val showTitle by remember { mutableStateOf(hasTitle) }

    TopAppBar(
        backgroundColor = DarkBlue,
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                if (isVisible) {
                    Icon(
                        painter = rememberAsyncImagePainter(com.google.android.material.R.drawable.ic_search_black_24),
                        contentDescription = "Image",
                        modifier = Modifier
                            .clickable {
                                navigator.navigate(SearchScreenDestination)
                            }
                            .padding(horizontal = 8.dp),
                        tint = LightGreen
                    )
                }

                if (showTitle) {
                    Text(text = title, color = LightGreen, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }

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