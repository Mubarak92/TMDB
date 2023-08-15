package com.mubarak.tmdb.ui.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mubarak.tmdb.ui.screens.main.MoviesViewModel
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightBlue

@Composable
fun TabRowComponent(
    viewModel: MoviesViewModel = hiltViewModel(),
) {
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }

    val list = listOf(
        (TabRowItems("Movies", "movie")),
        (TabRowItems("Tv Shows", "tv")),
    )

    TabRow(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        selectedTabIndex = selectedIndex,
        backgroundColor = DarkBlue,
        contentColor = Color.White,
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(it[selectedIndex]),
                height = 5.dp,
                color = LightBlue
            )
        }
    ) {
        list.forEachIndexed { index, movieItem ->
            Tab(selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index

                    viewModel.getTrendingNow(pathType = movieItem.type)
                },
                text = { Text(text = movieItem.name) }
            )
        }
    }
}

data class TabRowItems(val name: String, val type: String)