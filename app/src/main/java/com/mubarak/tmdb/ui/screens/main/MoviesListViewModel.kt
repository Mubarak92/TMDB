package com.mubarak.tmdb.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.domain.repository.IMovieRepository
import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse.Companion.toUiMovieList
import com.mubarak.tmdb.utils.MovieListViewState
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
class MoviesListViewModel @Inject constructor(private val movieRepository: IMovieRepository) :
    ViewModel() {

    var currentType = "movie"

    private val _viewState = MutableStateFlow<MovieListViewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun getTrendingNow(
        language: String = "en-US",
        pathType: String = currentType
    ) {
        movieRepository.getTrendingNow(language, pathType)
            .onStart { _viewState.emit(MovieListViewState(isLoading = true)) }
            .map { it.toUiMovieList() }
            .onEach { _viewState.emit(MovieListViewState(data = it.orEmpty())) }
            .catch {
                _viewState.emit(
                    MovieListViewState(
                        error = _viewState.value?.error ?: throw Exception(it)
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
}