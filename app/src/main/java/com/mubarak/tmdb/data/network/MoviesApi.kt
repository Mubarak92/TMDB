package com.mubarak.tmdb.data.network

import com.mubarak.tmdb.data.network.Constant.API_KEY
import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page_number") pageNumber: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") genres: Int,
        @Query("language") language: String = "en-US"
    ): ApiMovieModelResponse

    @GET("3/movie/popular")
    suspend fun searchMovies(
        @Query("page_number") pageNumber: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String? = "en-US",
        @Query("query") query: String?
    ): ApiMovieModelResponse
}