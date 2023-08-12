package com.mubarak.tmbd.data.domain.repository

import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getMovies(pageNumber: Int): Flow<ApiMovieModelResponse>

}