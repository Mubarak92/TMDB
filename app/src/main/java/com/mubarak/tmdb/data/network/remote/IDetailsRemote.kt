package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.ApiDetailsModelResponse
import kotlinx.coroutines.flow.Flow

interface IDetailsRemote {

    fun getMovieDetails(
        language: String,
        pathType: String,
        movieId: Int
    ): Flow<ApiDetailsModelResponse>
}