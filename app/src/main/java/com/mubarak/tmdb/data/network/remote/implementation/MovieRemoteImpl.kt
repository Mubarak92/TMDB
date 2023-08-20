package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.MoviesApi
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import com.mubarak.tmdb.data.network.remote.IMovieRemote
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

    override fun getPopularMovies(pageNumber: Int, genres: Int,language: String): Flow<ApiMovieModelResponse> =
        flow {
            emit(api.getPopularMovies(pageNumber, genres = genres, language = language))
        }

    override fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse> =
        flow {
            emit(api.searchMovies(pageNumber = pageNumber, query = query))
        }

    override fun getTrendingNow(language: String,pathType:String): Flow<ApiMovieModelResponse> = flow {
        emit(api.trendingNow(language = language, pathType = pathType))
    }
}