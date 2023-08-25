package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PeopleApi {

    @GET("3/trending/person/week")
    suspend fun trendingPeople(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int,
        @Query("total_result1s") totalPages: Int
    ): ApiPeopleModelResponse

    @GET("3/person/{person_id}")
    suspend fun peopleDetails(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") language: String?,
    ): ApiPeopleDetailsModelResponse


    @GET("3/person/{person_id}/images")
    suspend fun peopleImages(
        @Path("person_id") personId: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY,
    ): ApiPeopleImagesResponse

}