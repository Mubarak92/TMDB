package com.mubarak.tmdb.domain.repository

import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse
import kotlinx.coroutines.flow.Flow

interface ITvShowsRepository {

    fun getTvShows(language: String, page: Int, tvPathType: String): Flow<ApiTvShowsModelResponse>

}