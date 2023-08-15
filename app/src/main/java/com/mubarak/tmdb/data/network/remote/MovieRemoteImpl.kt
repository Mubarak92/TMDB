package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.MoviesApi
import com.mubarak.tmdb.data.network.model.ApiMovieModelResponse
import com.mubarak.tmdb.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : IMovieRemote {

    private val api = retrofitClient.getService(MoviesApi::class.java)

    override fun getPopularMovies(pageNumber: Int, genres: Int): Flow<ApiMovieModelResponse> =
        flow {
            emit(api.getPopularMovies(pageNumber, genres = genres))
        }

    override fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse> =
        flow {
            emit(api.searchMovies(pageNumber = pageNumber, query = query))
        }



    override fun getTrendingNow(language: String,pathType:String): Flow<ApiMovieModelResponse> = flow {
        emit(api.trendingNow(language = language, pathType = pathType))
    }
}