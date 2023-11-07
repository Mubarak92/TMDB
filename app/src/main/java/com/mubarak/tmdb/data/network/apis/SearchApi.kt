package com.mubarak.tmdb.data.network.apis

import com.mubarak.tmdb.data.network.Constant.API_KEY
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SearchApi {

    @GET("3/search/{pathType}")
    suspend fun getSearchedMovies(
        @Path("pathType") pathType: String = "movie",
        @Query("query") query: String,
        @Query("page") page: Int? = 1,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("language") language: String
    ): ApiMovieModelResponse

}