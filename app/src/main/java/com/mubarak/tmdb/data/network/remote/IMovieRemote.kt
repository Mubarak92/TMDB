package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRemote {
    fun getMovies(pageNumber: Int): Flow<ApiMovieModelResponse>
}