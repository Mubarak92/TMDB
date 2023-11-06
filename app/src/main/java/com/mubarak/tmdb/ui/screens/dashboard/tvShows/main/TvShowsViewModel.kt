package com.mubarak.tmdb.ui.screens.dashboard.tvShows.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse.Companion.toUiTvShowsList
import com.mubarak.tmdb.domain.repository.ITvShowsRepository
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
class TvShowsViewModel @Inject constructor(
    private val tvShowsRepository: ITvShowsRepository,
    private val appPrefs: IAppPrefs
) : ViewModel() {

    private val _airingTodayViewState = MutableStateFlow<TvShowsAiringTodayViewState?>(null)
    val airingTodayViewState = _airingTodayViewState.asStateFlow()

    private val _onAirViewState = MutableStateFlow<TvShowsOnAirViewState?>(null)
    val onAirViewState = _onAirViewState.asStateFlow()

    private val _popularViewState = MutableStateFlow<TvShowsPopularViewState?>(null)
    val popularViewState = _popularViewState.asStateFlow()

    private val _topRatedViewState = MutableStateFlow<TvShowsTopRatedViewState?>(null)
    val topRatedViewState = _topRatedViewState.asStateFlow()


    init {
        getAiringTodayTvShowsList()
        getOnAirTvShowsList()
        getPopularTvShowsList()
        getTopRatedTvShowsList()
    }

    private fun getAiringTodayTvShowsList() {
        tvShowsRepository.getTvShows(appPrefs.locale, 1, "airing_today")
            .onStart { _airingTodayViewState.emit(TvShowsAiringTodayViewState(isLoading = true)) }
            .map { it.toUiTvShowsList() }
            .onEach { _airingTodayViewState.emit(TvShowsAiringTodayViewState(airingTodayList = it)) }
            .catch { throw Exception(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
    private fun getOnAirTvShowsList() {
        tvShowsRepository.getTvShows(appPrefs.locale, 1, "on_the_air")
            .onStart { _onAirViewState.emit(TvShowsOnAirViewState(isLoading = true)) }
            .map { it.toUiTvShowsList() }
            .onEach { _onAirViewState.emit(TvShowsOnAirViewState(onAirList = it)) }
            .catch { throw Exception(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
    private fun getPopularTvShowsList() {
        tvShowsRepository.getTvShows(appPrefs.locale, 1, "popular")
            .onStart { _popularViewState.emit(TvShowsPopularViewState(isLoading = true)) }
            .map { it.toUiTvShowsList() }
            .onEach { _popularViewState.emit(TvShowsPopularViewState(popularShowsList = it)) }
            .catch { throw Exception(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
    private fun getTopRatedTvShowsList() {
        tvShowsRepository.getTvShows(appPrefs.locale, 1, "top_rated")
            .onStart { _topRatedViewState.emit(TvShowsTopRatedViewState(isLoading = true)) }
            .map { it.toUiTvShowsList() }
            .onEach { _topRatedViewState.emit(TvShowsTopRatedViewState(topRatedList = it)) }
            .catch { throw Exception(it) }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
}