package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.ApiMovieDetailsModelResponse
import kotlinx.coroutines.flow.Flow

interface IDetailsRemote {

    fun getMovieDetails(
        language: String,
        pathType: String,
        movieId: Int?
    ): Flow<ApiMovieDetailsModelResponse>
}