package com.mubarak.tmbd.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmbd.ui.screens.main.components.MovieCard
import com.mubarak.tmbd.utils.ViewState

@Composable
fun MainScreen(moviesViewModel: MoviesViewModel = hiltViewModel()) {
    val state by moviesViewModel.viewState.collectAsStateWithLifecycle()

    Column(modifier = Modifier.fillMaxSize()) {
        when (state){
            is ViewState.Success -> MovieCard()
            else -> {}
        }
    }
}
