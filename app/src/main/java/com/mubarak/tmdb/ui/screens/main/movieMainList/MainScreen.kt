package com.mubarak.tmdb.ui.screens.main.movieMainList

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Snackbar
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.main.movieMainList.components.MainMovieListLazyRow
import com.mubarak.tmdb.ui.screens.main.movieMainList.components.TabRowComponent
import com.mubarak.tmdb.ui.screens.main.movieMainList.components.TopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun MainScreen(
    navigator: DestinationsNavigator,
    viewModel: MoviesListViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column(Modifier.fillMaxSize()) {

        TopBar()
        TabRowComponent()

        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())) {
            MainMovieListLazyRow(state, navigator, viewModel, "Trending Now")
            MainMovieListLazyRow(state, navigator, viewModel, "What's New")
            MainMovieListLazyRow(state, navigator, viewModel, "Other")

            if (state?.error == true) {
                Snackbar(modifier = Modifier.padding(4.dp),
                    action = {
                        Text(
                            text = "Try again",
                            modifier = Modifier.clickable {
                            })
                    }) {
                    Text("an error occurred")
                }
            }

            if (state?.isLoading == true) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

    }
}