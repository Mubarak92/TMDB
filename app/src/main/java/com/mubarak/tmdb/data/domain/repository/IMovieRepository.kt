package com.mubarak.tmdb.data.domain.repository

import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMovies(pageNumber: Int , genres: Int ): Flow<ApiMovieModelResponse>

}