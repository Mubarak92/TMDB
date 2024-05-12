package com.mubarak.tmdb.ui.screens.people.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse.Companion.toUiPeopleList
import com.mubarak.tmdb.domain.repository.IPeopleRepository
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
class PeopleViewModel @Inject constructor(
    private val peopleRepository: IPeopleRepository,
    private val appPrefs: IAppPrefs
) : ViewModel() {

    private var currentPage = 1

    private val _viewState = MutableStateFlow<PeopleViewState?>(null)
    val viewState = _viewState.asStateFlow()

    private fun getTrendingPeople() {
        peopleRepository.getTrendingPeople(appPrefs.locale, page = currentPage, totalPages = 1000, totalResult = 1000)
            .onStart {
                if (_viewState.value == null || _viewState.value?.data.isNullOrEmpty()) {
                    _viewState.emit(PeopleViewState(isLoading = true))
                }
            }
            .map {
                val newData = it.toUiPeopleList()
                val currentData = _viewState.value?.data ?: emptyList()
                PeopleViewState(data = currentData + newData)
            }
            .catch {
                _viewState.emit(
                    PeopleViewState(
                        error = _viewState.value?.error ?: throw Exception(it)
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .onEach { _viewState.emit(it) }
            .launchIn(viewModelScope)
    }

    fun getTrendingPeopleCounter(pageNumber: Int = 1) {
        currentPage = pageNumber
        getTrendingPeople()
    }

    fun loadMoreData() {
        if (currentPage < 10) {
            currentPage++
            getTrendingPeople()
        }
    }
}
