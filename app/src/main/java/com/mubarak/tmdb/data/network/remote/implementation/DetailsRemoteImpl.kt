package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.DetailsApi
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse
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
        movieId: Int?
    ): Flow<ApiMovieDetailsModelResponse> = flow {
        emit(api.movieDetails(language = language, movieId = movieId))
    }

}