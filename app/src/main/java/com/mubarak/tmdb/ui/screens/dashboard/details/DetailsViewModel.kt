package com.mubarak.tmdb.ui.screens.dashboard.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.local.repository.ItemsRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse.Companion.toUiDetails
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.domain.repository.IDetailsRepository
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
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val detailsRepository: IDetailsRepository,
    private val itemsRepository: ItemsRepository
) : ViewModel() {

    private val _viewState = MutableStateFlow<DetailsScreenViewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun getMovieDetails(
        language: String = "en-US",
        movieId: Int?
    ) {
        detailsRepository.getDetails(language, movieId)
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

    fun addToMyWatchlist(movie: MovieItem?) = viewModelScope.launch(Dispatchers.IO) {
        itemsRepository.insertItem(movie)
    }

}