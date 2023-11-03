package com.mubarak.tmdb.ui.screens.dashboard.movies.main.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mubarak.tmdb.R
import com.mubarak.tmdb.ui.screens.dashboard.movies.main.MoviesListViewModel
import com.mubarak.tmdb.ui.screens.dashboard.movies.main.MoviesScreen
import com.mubarak.tmdb.ui.screens.settings.SettingsScreen
import com.mubarak.tmdb.ui.theme.DarkBlue
import com.mubarak.tmdb.ui.theme.LightBlue
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabRowComponent(
    navigator: DestinationsNavigator,
    pagerState: PagerState
) {
    val tabIndex = pagerState.currentPage
    val coroutineScope = rememberCoroutineScope()

    val list = listOf(
        (TabRowItems(stringResource(id = R.string.movies), "movie")),
        (TabRowItems(stringResource(id = R.string.tv_shows), "tv")),
    )

    TabRow(
        modifier = Modifier
            .height(50.dp)
            .fillMaxWidth(),
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = DarkBlue,
        contentColor = Color.White,
        indicator = {
            TabRowDefaults.Indicator(
                modifier = Modifier.tabIndicatorOffset(it[tabIndex]),
                height = 5.dp,
                color = LightBlue
            )
        }
    ) {
        list.forEachIndexed { index, movieItem ->
            Tab(selected = pagerState.currentPage == index,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = { Text(text = movieItem.name) }
            )
        }
    }

    HorizontalPager(
        userScrollEnabled = false,
        state = pagerState,
        modifier = Modifier,
        pageSpacing = 0.dp,
        beyondBoundsPageCount = 2,
        pageSize = PageSize.Fill,
    ) { index ->
        when (index) {
            0 -> {
                MoviesScreen(navigator)
            }

            1 -> {
                SettingsScreen()
            }
        }
    }
}

data class TabRowItems(val name: String, val type: String)