package com.mubarak.tmdb.data.network.remote.implementation

import com.mubarak.tmdb.data.network.apis.PeopleApi
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleDetailsModelResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleImagesResponse
import com.mubarak.tmdb.data.network.model.apiPeopleModel.ApiPeopleModelResponse
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

    override fun getPeopleDetails(
        personId: Int,
        language: String
    ): Flow<ApiPeopleDetailsModelResponse> =
        flow {
            emit(api.peopleDetails( language = "en-US", personId = personId))
        }


    override fun getPeopleImages(personId: Int): Flow<ApiPeopleImagesResponse> =
        flow {
            emit(api.peopleImages(personId))
        }
}

