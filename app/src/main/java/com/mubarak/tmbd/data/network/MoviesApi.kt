package com.mubarak.tmbd.data.network

import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("/movie/popular?language=en-US")
    suspend fun getPopularMovies (
        @Query("page_number") pageNumber: Int = 1
    ) : ApiMovieModelResponse
}