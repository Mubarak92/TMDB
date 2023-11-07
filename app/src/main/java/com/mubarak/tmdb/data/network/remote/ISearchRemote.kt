package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import kotlinx.coroutines.flow.Flow

interface ISearchRemote {

    fun getSearchedMovies(page: Int, query: String,language: String): Flow<ApiMovieModelResponse>

}