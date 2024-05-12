package com.mubarak.tmdb.domain.implementation

import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import com.mubarak.tmdb.data.network.remote.ISearchRemote
import com.mubarak.tmdb.domain.repository.ISearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRepositoryImpl @Inject constructor(private val searchRemote: ISearchRemote) :
    ISearchRepository {

    override fun getSearchedMovies(
        page: Int,
        query: String,
        language: String
    ): Flow<ApiMovieModelResponse> =
        searchRemote.getSearchedMovies(page, query, language)

}