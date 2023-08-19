package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.data.network.model.ApiPeopleModelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleApi {

    @GET("3/trending/person/week")
    suspend fun trendingPeople(
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") language: String?,
        @Query("page") page: Int,
        @Query("total_result1s") totalPages: Int
    ): ApiPeopleModelResponse
}