package com.mubarak.tmbd.data.domain

import com.mubarak.tmbd.data.domain.repository.IMovieRepository
import com.mubarak.tmbd.data.network.model.ApiMovieModelResponse
import com.mubarak.tmbd.data.network.remote.IMovieRemote
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImpl @Inject constructor(private val movieRemote: IMovieRemote) : IMovieRepository {


    override fun getMovies(pageNumber: Int): Flow<ApiMovieModelResponse> = movieRemote.getMovies(pageNumber)
}