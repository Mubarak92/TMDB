package com.mubarak.tmdb.data.domain.repository

import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getPopularMovies(pageNumber: Int, genres: Int,language: String): Flow<ApiMovieModelResponse>
    fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse>
    fun getTrendingNow(language: String, pathType: String): Flow<ApiMovieModelResponse>

}