package com.mubarak.tmdb.ui.screens.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse.Companion.toUiMovieList
import com.mubarak.tmdb.domain.repository.ISearchRepository
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
class SearchViewModel @Inject constructor(
    private val searchRepository: ISearchRepository,
    private val appPrefs: IAppPrefs
) : ViewModel() {

    private val _viewState = MutableStateFlow<SearchViewState?>(null)
    val viewState = _viewState.asStateFlow()

    fun getSearchedList(
        searchQuery: String
    ) {
        searchRepository.getSearchedMovies(
            query = searchQuery,
            language = appPrefs.locale,
            page = 1
        )
            .onStart { _viewState.emit(SearchViewState(isLoading = true)) }
            .map { it.toUiMovieList() }
            .onEach { _viewState.emit(SearchViewState(data = it)) }
            .catch {
                _viewState.emit(SearchViewState(isLoading = false))
                Log.e("SearchViewModel", "getSearchedList: SearchViewModel = $it ")
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

}