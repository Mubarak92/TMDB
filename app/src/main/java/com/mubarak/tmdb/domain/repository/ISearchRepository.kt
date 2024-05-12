package com.mubarak.tmdb.domain.repository

import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface ISearchRepository {

    fun getSearchedMovies(page: Int, query: String,language: String): Flow<ApiMovieModelResponse>

}