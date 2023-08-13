package com.mubarak.tmdb.ui.screens.main.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ScrollableTabRow
import androidx.compose.material.Tab
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ScrollableTextTabComponent() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val list = listOf(
        (ScrollableTabs("First", 1)), ScrollableTabs("Second", 2), ScrollableTabs("third", 3)
    )
    ScrollableTabRow(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        edgePadding = 8.dp,
        selectedTabIndex = selectedIndex
    ) {
        list.forEachIndexed { index, text ->
            Tab(selected = selectedIndex == index,
                onClick = { selectedIndex = index },
                text = { Text(text = text.name) }
            )
        }
    }
}

data class ScrollableTabs(val name: String, val id: Int)