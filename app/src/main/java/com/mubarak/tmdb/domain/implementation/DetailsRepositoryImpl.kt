package com.mubarak.tmdb.domain.implementation

import com.mubarak.tmdb.domain.repository.IDetailsRepository
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieDetailsModelResponse
import com.mubarak.tmdb.data.network.remote.IDetailsRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DetailsRepositoryImpl @Inject constructor(private val detailsRemote: IDetailsRemote) :
    IDetailsRepository {

    override fun getDetails(
        language: String,
        movieId: Int?
    ): Flow<ApiMovieDetailsModelResponse> =
        detailsRemote.getMovieDetails(language = language, movieId = movieId)

}