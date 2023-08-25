package com.mubarak.tmdb.domain.implementation

import com.mubarak.tmdb.domain.repository.IMovieRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import com.mubarak.tmdb.data.network.remote.IMovieRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(private val movieRemote: IMovieRemote) :
    IMovieRepository {

    override fun getPopularMovies(pageNumber: Int, genres: Int,language: String): Flow<ApiMovieModelResponse> =
        movieRemote.getPopularMovies(pageNumber, genres,language)

    override fun getSearchedMovies(pageNumber: Int, query: String?): Flow<ApiMovieModelResponse> =
        movieRemote.getSearchedMovies(pageNumber, query)

    override fun getTrendingNow(language: String, pathType: String): Flow<ApiMovieModelResponse> =
        movieRemote.getTrendingNow(language, pathType = pathType)
}