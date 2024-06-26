package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleMovieCredits
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleSocial
import kotlinx.coroutines.flow.Flow

interface IPeopleRemote {

    fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int,
        totalResults: Int
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