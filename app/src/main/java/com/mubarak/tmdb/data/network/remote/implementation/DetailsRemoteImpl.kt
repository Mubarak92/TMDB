package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.DetailsApi
import com.mubarak.tmdb.data.network.model.ApiDetailsModelResponse
import com.mubarak.tmdb.data.network.remote.IDetailsRemote
import com.mubarak.tmdb.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : IDetailsRemote {

    private val api = retrofitClient.getService(DetailsApi::class.java)

    override fun getMovieDetails(
        language: String,
        pathType: String,
        movieId: Int
    ): Flow<ApiDetailsModelResponse> = flow {
        emit(api.movieDetails(language = language, pathType = pathType, movieId = movieId))
    }

}