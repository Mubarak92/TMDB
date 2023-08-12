package com.mubarak.tmbd.data.network

import com.mubarak.tmbd.data.network.Constant.API_KEY
import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/movie/popular?language=en-US")
    suspend fun getPopularMovies(
        @Query("page_number") pageNumber: Int = 1,
        @Query("api_key") apiKey: String = API_KEY
    ): ApiMovieModelResponse
}