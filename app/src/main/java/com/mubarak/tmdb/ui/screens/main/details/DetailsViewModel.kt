package com.mubarak.tmdb.ui.screens.main.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.domain.model.DetailsItem
import com.mubarak.tmdb.data.domain.repository.IDetailsRepository
import com.mubarak.tmdb.data.network.model.ApiDetailsModelResponse.Companion.toUiDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val detailsRepository: IDetailsRepository) :
    ViewModel() {

    private val _viewState = MutableStateFlow<DetailsItem?>(null)
    val viewState = _viewState.asStateFlow()

    fun getMovieDetails(
        language: String = "en-US",
        pathType: String,
        movieId: Int
    ) {
        detailsRepository.getDetails(language, pathType, movieId)
            .map { it.toUiDetails() }
            .onStart { }
            .onEach { _viewState.emit(it) }
            //   .catch { _error.emit(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }


}