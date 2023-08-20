package com.mubarak.tmdb.ui.screens.people.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.data.domain.model.peopleModel.PeopleResultsItem
import com.mubarak.tmdb.ui.screens.people.component.PeopleCard
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PeopleScreen(
    navigator: DestinationsNavigator,
    viewModel: PeopleViewModel = hiltViewModel()
) {
    val state by viewModel.viewState.collectAsStateWithLifecycle()

    Column {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            content = {
                items(state?.data.orEmpty()) { item: PeopleResultsItem ->
                    PeopleCard(personName = item.name, personImage = item.profilePath, personId = item.id!!, navigator = navigator)
                }
            })
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
