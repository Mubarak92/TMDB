package com.mubarak.tmdb.ui.screens.people.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.ui.screens.dashboard.details.components.DetailsTopBar
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PeopleDetailsScreen(
    personId: Int,
    title: String,
    navigator: DestinationsNavigator,

    viewModel: PeopleDetailsViewModel = hiltViewModel()
) {

    val state by viewModel.viewState.collectAsStateWithLifecycle()
    DetailsTopBar(title = title, navigator)

    LaunchedEffect(null) {
        viewModel.getPersonDetails(personId = personId)
    }
}