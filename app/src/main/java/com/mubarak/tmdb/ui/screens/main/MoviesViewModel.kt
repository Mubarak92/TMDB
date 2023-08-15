package com.mubarak.tmdb.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.domain.model.MovieItem
import com.mubarak.tmdb.data.domain.repository.IMovieRepository
import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse.Companion.toUiMovieList
import com.mubarak.tmdb.utils.ViewState
import com.mubarak.tmdb.utils.toViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: IMovieRepository) : ViewModel() {

    private val _viewState = MutableStateFlow<ViewState<List<MovieItem>>>(ViewState.loading())
    val viewState = _viewState.asStateFlow()

    init {
        getTrendingNow()
    }

    fun getTrendingNow(
        language: String = "en-US",
        pathType: String = "movie"

    ) {
        movieRepository.getTrendingNow(language, pathType)
            .map { it.toUiMovieList() }
            .onEach { _viewState.emit(ViewState.success(it.orEmpty())) }
            .catch { _viewState.emit(it.toViewState()) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

}