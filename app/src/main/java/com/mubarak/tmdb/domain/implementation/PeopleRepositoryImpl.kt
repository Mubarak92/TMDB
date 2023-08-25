package com.mubarak.tmdb.domain.implementation

import com.mubarak.tmdb.domain.repository.IPeopleRepository
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleMovieCredits
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleSocial
import com.mubarak.tmdb.data.network.remote.IPeopleRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PeopleRepositoryImpl @Inject constructor(private val peopleRemote: IPeopleRemote) :
    IPeopleRepository {

    override fun getTrendingPeople(
        language: String, page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse> =
        peopleRemote.getTrendingPeople(language = language, page = page, totalPages = totalPages)

    override fun getPeopleDetails(
        personId: Int,
        language: String
    ): Flow<ApiPeopleDetailsModelResponse> =
        peopleRemote.getPeopleDetails(language = language, personId = personId)


    override fun getPeopleImages(personId: Int): Flow<ApiPeopleImagesResponse> =
        peopleRemote.getPeopleImages(personId)


    override fun peopleMovieCredits(personId: Int): Flow<ApiPeopleMovieCredits> =
        peopleRemote.peopleMovieCredits(personId)


    override fun peopleSocial(personId: Int): Flow<ApiPeopleSocial> =
        peopleRemote.peopleSocial(personId)
}