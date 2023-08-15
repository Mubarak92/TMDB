package com.mubarak.tmdb.ui.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.domain.model.DetailsItem
import com.mubarak.tmdb.data.domain.repository.IDetailsRepository
import com.mubarak.tmdb.data.network.model.ApiDetailsModelResponse.Companion.toUiDetails
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
class DetailsViewModel @Inject constructor(private val detailsRepository: IDetailsRepository) :
    ViewModel() {

    private val _viewState = MutableStateFlow<ViewState<DetailsItem>>(ViewState.loading())
    val viewState = _viewState.asStateFlow()

    fun getMovieDetails(
        language: String = "en-US",
        pathType: String = "movie",
        movieId: Int
    ) {
        detailsRepository.getDetails(language, pathType, movieId)
            .map { it.toUiDetails() }
            .onEach { _viewState.emit(ViewState.success(it)) }
            .catch { _viewState.emit(it.toViewState()) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }


}