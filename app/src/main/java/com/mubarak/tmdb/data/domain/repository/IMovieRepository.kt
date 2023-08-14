package com.mubarak.tmdb.data.domain.repository

import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getPopularMovies(pageNumber: Int, genres: Int): Flow<ApiMovieModelResponse>
    fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse>

}