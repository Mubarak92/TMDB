package com.mubarak.tmdb.ui.screens.dashboard.movies.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.local.repository.ItemsRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse.Companion.toUiDetails
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import com.mubarak.tmdb.domain.repository.IDetailsRepository
import com.mubarak.tmdb.ui.commen.appPref.IAppPrefs
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
class MoviesDetailsViewModel @Inject constructor(
    private val detailsRepository: IDetailsRepository,
    private val itemsRepository: ItemsRepository,
    private val appPrefs: IAppPrefs
) : ViewModel() {

    private val _viewState = MutableStateFlow<MoviesDetailsScreenViewState?>(null)
    val viewState = _viewState.asStateFlow()

    private val _itemViewState = MutableStateFlow(false)
    val itemViewState = _itemViewState.asStateFlow()

    fun getMovieDetails(
        movieId: Int?
    ) {
        detailsRepository.getDetails(appPrefs.locale, movieId)
            .onStart { _viewState.emit(MoviesDetailsScreenViewState(isLoading = true)) }
            .map { it.toUiDetails() }
            .onEach { _viewState.emit(MoviesDetailsScreenViewState(data = it)) }
            .catch {
                _viewState.emit(
                    MoviesDetailsScreenViewState(
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

    fun removeFromFavorite(movie: MovieItem) = viewModelScope.launch(Dispatchers.IO) {
        itemsRepository.deleteItem(movie)
    }

    fun checkIfItemIsExists(movie: MovieItem) = itemsRepository.isExists(movie.id)
        .onEach {
            _itemViewState.emit(it)
        }.flowOn(Dispatchers.IO)
        .launchIn(viewModelScope)


}