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
) :
    ViewModel() {

    private val _viewState = MutableStateFlow<PeopleViewState?>(null)
    val viewState = _viewState.asStateFlow()

    init {
        getTrendingPeople()
    }

    private fun getTrendingPeople() {
        peopleRepository.getTrendingPeople(appPrefs.locale, page = 1, totalPages = 10)
            .onStart { _viewState.emit(PeopleViewState(isLoading = true)) }
            .map { it.toUiPeopleList() }
            .onEach { _viewState.emit(PeopleViewState(data = it)) }
            .catch {
                _viewState.emit(
                    PeopleViewState(
                        error = _viewState.value?.error ?: throw Exception(it)
                    )
                )
            }
                .flowOn(Dispatchers.IO)
                .launchIn(viewModelScope)
        }
}