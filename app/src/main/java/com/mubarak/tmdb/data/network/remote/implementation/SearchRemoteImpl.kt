package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.SearchApi
import com.mubarak.tmdb.data.network.model.apiMovieModel.ApiMovieModelResponse
import com.mubarak.tmdb.data.network.remote.ISearchRemote
import com.mubarak.tmdb.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : ISearchRemote {
    private val api = retrofitClient.getService(SearchApi::class.java)

    override fun getSearchedMovies(page: Int, query: String,language: String): Flow<ApiMovieModelResponse> =
        flow {
            emit(api.getSearchedMovies(page = page, query = query,language = language))
        }
}