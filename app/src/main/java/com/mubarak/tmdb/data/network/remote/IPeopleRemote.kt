package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.ApiPeopleModelResponse
import kotlinx.coroutines.flow.Flow

interface IPeopleRemote {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse>

}