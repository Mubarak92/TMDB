package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TvShowsApi {

    @GET("3/tv/{tv_type}")
    suspend fun getTvShows(
        @Path("tv_type") tvPathType: String,
        @Query("language") language: String?,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = Constant.API_KEY,
    ): ApiTvShowsModelResponse

}