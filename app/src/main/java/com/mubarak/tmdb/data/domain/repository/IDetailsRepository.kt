package com.mubarak.tmdb.data.domain.repository

import com.mubarak.tmdb.data.network.model.ApiDetailsModelResponse
import kotlinx.coroutines.flow.Flow

interface IDetailsRepository {

    fun getDetails(
        language: String,
        pathType: String,
        movieId: Int
    ): Flow<ApiDetailsModelResponse>

}