package com.mubarak.tmbd.data.network.remote

import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface IMovieRemote {
    fun getMovies (pageNumber:Int ): Flow<ApiMovieModelResponse>
}