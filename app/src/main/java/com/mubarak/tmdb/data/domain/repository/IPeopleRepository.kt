package com.mubarak.tmdb.data.domain.repository

import com.mubarak.tmdb.data.network.model.ApiPeopleModelResponse
import kotlinx.coroutines.flow.Flow

interface IPeopleRepository {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse>

}