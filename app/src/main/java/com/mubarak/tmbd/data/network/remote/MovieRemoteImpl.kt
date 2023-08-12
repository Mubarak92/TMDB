package com.mubarak.tmbd.data.network.remote

import com.mubarak.tmbd.data.network.MoviesApi
import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import com.mubarak.tmbd.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : IMovieRemote {

    private val api = retrofitClient.getService(MoviesApi::class.java)

    override fun getMovies(pageNumber: Int): Flow<ApiMovieModelResponse> = flow {
        emit(api.getPopularMovies(pageNumber))
    }
}