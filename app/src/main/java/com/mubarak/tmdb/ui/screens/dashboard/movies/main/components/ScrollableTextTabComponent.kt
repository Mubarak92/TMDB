package com.mubarak.tmdb.ui.screens.dashboard.movies.main.components

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightGreen

@Composable
fun ScrollableTextTabComponent(isVisible: Boolean) {

    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    val list = listOf("Streaming", "On TV", "For Rent", "In Theatres")

    if (isVisible) {
        ScrollableTabRow(
            selectedTabIndex = selectedIndex,
            backgroundColor = DarkBlue,
            modifier = Modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .clip(RoundedCornerShape(50))
                .background(DarkBlue)
                .padding(1.dp)
        ) {
            list.forEachIndexed { index, text ->
                val selected = selectedIndex == index
                Tab(
                    modifier = if (selected) Modifier
                        .clip(RoundedCornerShape(50))
                        .background(Color.White)
                    else Modifier
                        .clip(RoundedCornerShape(50))
                        .background(DarkBlue),
                    selected = selected,
                    onClick = { selectedIndex = index },
                    text = { Text(text = text, color = LightGreen) }
                )
            }
        }
    }
}


@Preview
@Preview("dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(device = Devices.PIXEL_C)
@Composable
private fun CustomTabsbComponentPreview() {
    Column {
        ScrollableTextTabComponent(true)
    }
}