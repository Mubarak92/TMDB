package com.mubarak.tmdb.data.domain.implementation

import com.mubarak.tmdb.data.domain.repository.IPeopleRepository
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
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
        peopleRemote.getTrendingPeople(
            language = language,
            page = page, totalPages = totalPages
        )

    override fun getPeopleDetails(
        personId: Int,
        language: String
    ): Flow<ApiPeopleDetailsModelResponse> =
        peopleRemote.getPeopleDetails(language = language, personId = personId)

}