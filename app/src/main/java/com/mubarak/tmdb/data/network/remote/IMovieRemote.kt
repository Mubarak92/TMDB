package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRemote {
    fun getPopularMovies(pageNumber: Int, genres: Int): Flow<ApiMovieModelResponse>
    fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse>
    fun getTrendingNow(language: String,pathType:String): Flow<ApiMovieModelResponse>
}