package com.mubarak.tmdb.domain.repository

import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse
import kotlinx.coroutines.flow.Flow

interface IDetailsRepository {

    fun getDetails(
        language: String,
        movieId: Int?
    ): Flow<ApiMovieDetailsModelResponse>

}