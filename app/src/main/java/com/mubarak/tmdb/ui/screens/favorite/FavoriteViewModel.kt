package com.mubarak.tmdb.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.local.repository.ItemsRepository
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(itemsRepository: ItemsRepository) : ViewModel() {


    val favoriteUiState: StateFlow<FavoriteUiState> =
        itemsRepository.getAllItemsStream().map { FavoriteUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = FavoriteUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }


}

data class FavoriteUiState(val itemList: List<MovieItem> = listOf())
