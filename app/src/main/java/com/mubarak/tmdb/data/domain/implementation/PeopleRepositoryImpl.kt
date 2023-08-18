package com.mubarak.tmdb.data.domain.implementation

import com.mubarak.tmdb.data.domain.repository.IPeopleRepository
import com.mubarak.tmdb.data.network.model.ApiPeopleModelResponse
import com.mubarak.tmdb.data.network.remote.IPeopleRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PeopleRepositoryImpl @Inject constructor(private val peopleRemote: IPeopleRemote) :
    IPeopleRepository {

    override fun getTrendingPeople(language: String): Flow<ApiPeopleModelResponse> =
        peopleRemote.getTrendingPeople(language)
}