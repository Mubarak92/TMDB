package com.mubarak.tmdb.ui.screens.dashboard.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.local.entities.MovieEntity
import com.mubarak.tmdb.data.local.repository.ItemsRepository
import com.mubarak.tmdb.domain.repository.IDetailsRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse.Companion.toUiDetails
import com.mubarak.tmdb.domain.model.movieModel.MovieDetailsItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: IDetailsRepository,
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private var itemUiState by mutableStateOf(ItemUiState())

    private val _viewState = MutableStateFlow<DetailsScreenViewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun getMovieDetails(
        language: String = "en-US",
        pathType: String,
        movieId: Int?
    ) {
        detailsRepository.getDetails(language, pathType, movieId)
            .onStart { _viewState.emit(DetailsScreenViewState(isLoading = true)) }
            .map { it.toUiDetails() }
            .onEach { _viewState.emit(DetailsScreenViewState(data = it)) }
            .catch {
                _viewState.emit(
                    DetailsScreenViewState(
                        error = _viewState.value?.error ?: throw Exception()
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    suspend fun saveItem() {
        itemsRepository.insertItem(itemUiState.itemDetails.)
    }
}

data class ItemUiState(
    val itemDetails: ItemDetails = ItemDetails(),
    val isEntryValid: Boolean = false
)

data class ItemDetails(
    val id: Int = 0,
    val title: String? = null,
    val originalTitle: String? = null,
    val posterPath: String? = null,
)

fun ItemDetails.toItem(): MovieEntity = MovieEntity(
    id = id,
    title = title,
    originalTitle = originalTitle,
    posterPath = posterPath
)