package com.mubarak.tmdb.domain.repository

import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleMovieCredits
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleSocial
import kotlinx.coroutines.flow.Flow

interface IPeopleRepository {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int,
        totalResult:Int
    ): Flow<ApiPeopleModelResponse>

    fun getPeopleDetails(
        personId:Int,
        language: String,
    ): Flow<ApiPeopleDetailsModelResponse>

  fun getPeopleImages(
        personId:Int,
    ): Flow<ApiPeopleImagesResponse>

  fun peopleMovieCredits(
        personId:Int,
    ): Flow<ApiPeopleMovieCredits>

 fun peopleSocial(
        personId:Int,
    ): Flow<ApiPeopleSocial>

}