package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import kotlinx.coroutines.flow.Flow

interface IPeopleRemote {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse>

    fun getPeopleDetails(
        personId:Int,
        language: String,
    ): Flow<ApiPeopleDetailsModelResponse>

}