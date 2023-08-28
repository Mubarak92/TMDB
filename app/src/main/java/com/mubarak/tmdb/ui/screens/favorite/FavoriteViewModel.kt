package com.mubarak.tmdb.ui.screens.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.local.entities.MovieEntity
import com.mubarak.tmdb.data.local.repository.ItemsRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(itemsRepository: ItemsRepository) :
    ViewModel() {


    val homeUiState: StateFlow<FavoriteUiState> =
        itemsRepository.getAllItemsStream().map { FavoriteUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000L),
                initialValue = FavoriteUiState()
            )

    data class FavoriteUiState(val itemList: List<MovieEntity> = listOf())

}