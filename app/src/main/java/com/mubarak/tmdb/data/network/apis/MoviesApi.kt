package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant.API_KEY
import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApi {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("page_number") pageNumber: Int = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("with_genres") genres: Int,
        @Query("language") language: String
    ): ApiMovieModelResponse

    @GET("3/movie/search")
    suspend fun searchMovies(
        @Query("page_number") pageNumber: Int = 1,
        @Query("query") query: String?
    ): ApiMovieModelResponse


    @GET("3/trending/{pathType}/week")
    suspend fun trendingNow(
        @Path("pathType") pathType: String,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String? = "en-US",
    ): ApiMovieModelResponse
}