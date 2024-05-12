package com.mubarak.tmdb.ui.screens.people.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mubarak.tmdb.domain.model.peopleModel.PeopleResultsItem
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

    LaunchedEffect(key1 = null) {
        viewModel.getTrendingPeopleCounter()
    }

    val lazyGridState = rememberLazyGridState()

    LazyVerticalGrid(
        state = lazyGridState,
        columns = GridCells.Fixed(2),
        content = {
            itemsIndexed(state?.data.orEmpty()) { index, item: PeopleResultsItem ->
                PeopleCard(personName = item.name, personImage = item.profilePath, personId = item.id!!, navigator = navigator)
                // Trigger loading more data when reaching the end of the list
                if (index == state?.data?.size?.minus(2)) {
                    viewModel.loadMoreData()
                }
            }
        }
    )

    // Display loading indicator if data is still loading and the list is not empty
    if (state?.isLoading == true && state?.data?.isNotEmpty() == true) {
        Box(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
