package com.mubarak.tmdb.data.network.remote

import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse
import kotlinx.coroutines.flow.Flow

interface ITvShowsRemote {
    fun getTvShows(
        language: String,
        page: Int,
        tvPathType:String
    ): Flow<ApiTvShowsModelResponse>

}