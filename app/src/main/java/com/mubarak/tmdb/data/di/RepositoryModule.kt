package com.mubarak.tmdb.data.di

import com.mubarak.tmdb.data.domain.implementation.DetailsRepositoryImpl
import com.mubarak.tmdb.data.domain.implementation.MovieRepositoryImpl
import com.mubarak.tmdb.data.domain.implementation.PeopleRepositoryImpl
import com.mubarak.tmdb.data.domain.repository.IDetailsRepository
import com.mubarak.tmdb.data.domain.repository.IMovieRepository
import com.mubarak.tmdb.data.domain.repository.IPeopleRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): IMovieRepository

    @Binds
    abstract fun bindDetailsRepository(detailsRepositoryImpl: DetailsRepositoryImpl): IDetailsRepository

    @Binds
    abstract fun bindPeopleRepository(peopleRepositoryImpl: PeopleRepositoryImpl): IPeopleRepository
}