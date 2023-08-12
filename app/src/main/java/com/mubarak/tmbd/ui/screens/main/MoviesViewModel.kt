package com.mubarak.tmbd.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmbd.data.domain.model.MovieItem
import com.mubarak.tmbd.data.domain.repository.IMovieRepository
import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse.Companion.toUiMovieList
import com.mubarak.tmbd.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val movieRepository: IMovieRepository) :
    ViewModel() {

    private val _viewState = MutableStateFlow<ViewState<List<MovieItem>>>(ViewState.loading())
    val viewState = _viewState.asStateFlow()

    init {
        getMovies()
    }

    fun getMovies() {
        movieRepository.getMovies(1)
            .take(1)
            .map { it.toUiMovieList() }
            .onEach { _viewState.emit(ViewState.success(it!!)) }
            .catch { error("Erorr!") }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
}