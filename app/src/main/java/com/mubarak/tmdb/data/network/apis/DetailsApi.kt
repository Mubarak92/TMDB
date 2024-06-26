package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DetailsApi {

    @GET("3/{pathType}/{movie_id}")
    suspend fun movieDetails(
        @Path("pathType") pathType: String = "movie",
        @Path("movie_id") movieId: Int?,
        @Query("api_key") apiKey: String = Constant.API_KEY,
        @Query("language") language: String,
    ): ApiMovieDetailsModelResponse
}