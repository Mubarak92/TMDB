package com.mubarak.tmdb.data.di

import com.mubarak.tmdb.data.domain.MovieRepositoryImpl
import com.mubarak.tmdb.data.domain.repository.IMovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): IMovieRepository
}