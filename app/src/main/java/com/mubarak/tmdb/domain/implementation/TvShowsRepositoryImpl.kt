package com.mubarak.tmdb.domain.implementation

import com.mubarak.tmdb.data.network.model.apiTvShowsModel.ApiTvShowsModelResponse
import com.mubarak.tmdb.data.network.remote.ITvShowsRemote
import com.mubarak.tmdb.domain.repository.ITvShowsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TvShowsRepositoryImpl @Inject constructor(private val tvShowsRemote: ITvShowsRemote) :
    ITvShowsRepository {

    override fun getTvShows(
        language: String,
        page: Int,
        tvPathType: String
    ): Flow<ApiTvShowsModelResponse> =
        tvShowsRemote.getTvShows(language, page, tvPathType)
}