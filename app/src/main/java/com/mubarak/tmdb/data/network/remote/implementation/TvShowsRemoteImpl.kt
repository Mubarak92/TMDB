package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.TvShowsApi
import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse
import com.mubarak.tmdb.data.network.remote.ITvShowsRemote
import com.mubarak.tmdb.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TvShowsRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : ITvShowsRemote {
    private val api = retrofitClient.getService(TvShowsApi::class.java)

    override fun getTvShows(
        language: String,
        page: Int,
        tvPathType:String
    ): Flow<ApiTvShowsModelResponse> = flow {
        emit(api.getTvShows(page = page, language = language,tvPathType= tvPathType))
    }

}