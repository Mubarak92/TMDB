package com.mubarak.tmdb.ui.screens.people.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubarak.tmdb.domain.repository.IPeopleRepository
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse.Companion.toUiPeopleDetails
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse.Companion.toUiPeopleImagesList
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
class PeopleDetailsViewModel @Inject constructor(
    private val peopleDetailsRepository: IPeopleRepository,
    private val appPrefs: IAppPrefs
) :
    ViewModel() {

    private val _viewState = MutableStateFlow<PeopleDetailsViewState?>(null)
    val viewState = _viewState.asStateFlow()

    private val _imagesViewState = MutableStateFlow<PeopleImagesViewState?>(null)
    val imagesViewState = _imagesViewState.asStateFlow()

    private val _peopleMovieCreditsViewState = MutableStateFlow<PeopleMovieCreditsViewState?>(null)
    val peopleMovieCreditsViewState = _peopleMovieCreditsViewState.asStateFlow()

    private val _peopleSocialMediaViewState = MutableStateFlow<PeopleSocialMediaViewState?>(null)
    val peopleSocialMediaViewState = _peopleSocialMediaViewState.asStateFlow()

    fun getPersonDetails(
        personId: Int
    ) {
        peopleDetailsRepository.getPeopleDetails(language = appPrefs.locale, personId = personId)

            .onStart { _viewState.emit(PeopleDetailsViewState(isLoading = true)) }
            .map { it.toUiPeopleDetails() }
            .onEach { _viewState.emit(PeopleDetailsViewState(data = it)) }
            .catch {
                _viewState.emit(
                    PeopleDetailsViewState(
                        error2 = it
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun getPersonImages(
        personId: Int
    ) {
        peopleDetailsRepository.getPeopleImages(personId = personId)
            .onStart { _imagesViewState.emit(PeopleImagesViewState(isLoading = true)) }
            .map { it.toUiPeopleImagesList() }
            .onEach { _imagesViewState.emit(PeopleImagesViewState(data = it)) }
            .catch {
                _imagesViewState.emit(
                    PeopleImagesViewState(
                        error2 = it
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun getPersonMovieCredits(
        personId: Int
    ) {
        peopleDetailsRepository.peopleMovieCredits(personId = personId)
            .onStart { _peopleMovieCreditsViewState.emit(PeopleMovieCreditsViewState(isLoading = true)) }
            .onEach { _peopleMovieCreditsViewState.emit(PeopleMovieCreditsViewState(data = it.cast)) }
            .catch {
                _peopleMovieCreditsViewState.emit(
                    PeopleMovieCreditsViewState(
                        error2 = it
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun getPersonSocialMedia(
        personId: Int
    ) {
        peopleDetailsRepository.peopleSocial(personId = personId)
            .onStart { _peopleSocialMediaViewState.emit(PeopleSocialMediaViewState(isLoading = true)) }
            .onEach { _peopleSocialMediaViewState.emit(PeopleSocialMediaViewState(data = it)) }
            .catch {
                _peopleSocialMediaViewState.emit(
                    PeopleSocialMediaViewState(
                        error2 = it
                    )
                )
            }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }
}