package com.mubarak.tmdb.ui.screens.discover.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.domain.repository.IMovieRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse.Companion.toUiMovieList
import com.mubarak.tmdb.ui.commen.appPref.AppPrefs
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
import javax.inject.Inject

@HiltViewModel
class DiscoverDetailsViewModel @Inject constructor(private val movieRepository: IMovieRepository, private val appPrefs: IAppPrefs) :
    ViewModel() {

    private val _viewState = MutableStateFlow<DiscoverDetailsViewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun getMovieList(
        genres: Int
    ) {
        movieRepository.getPopularMovies(1,genres,appPrefs.locale)
            .onStart { _viewState.emit(DiscoverDetailsViewState(isLoading = true)) }
            .map { it.toUiMovieList() }
            .onEach { _viewState.emit(DiscoverDetailsViewState(data = it.orEmpty())) }
            .catch {
                _viewState.emit(
                    DiscoverDetailsViewState(
                        error = _viewState.value?.error ?: throw Exception(it)
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
}