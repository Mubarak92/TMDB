package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.PeopleApi
import com.mubarak.tmdb.data.network.model.ApiPeopleModelResponse
import com.mubarak.tmdb.data.network.remote.IPeopleRemote
import com.mubarak.tmdb.data.network.retrofit.RetrofitClient
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PeopleRemoteImpl @Inject constructor(
    retrofitClient: RetrofitClient
) : IPeopleRemote {

    private val api = retrofitClient.getService(PeopleApi::class.java)

    override fun getTrendingPeople(
        language: String,
        page: Int,
        totalPages: Int
    ): Flow<ApiPeopleModelResponse> =
        flow {
            emit(api.trendingPeople(page = page, language = "en-US", totalPages = totalPages))
        }
}