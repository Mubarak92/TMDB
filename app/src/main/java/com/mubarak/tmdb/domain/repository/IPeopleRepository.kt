package com.mubarak.tmdb.domain.repository

import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import kotlinx.coroutines.flow.Flow

interface IPeopleRepository {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse>

    fun getPeopleDetails(
        personId:Int,
        language: String,
    ): Flow<ApiPeopleDetailsModelResponse>

  fun getPeopleImages(
        personId:Int,
    ): Flow<ApiPeopleImagesResponse>

}