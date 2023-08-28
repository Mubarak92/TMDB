package com.mubarak.tmdb.data.di

import com.mubarak.tmdb.data.local.repository.ItemsRepository
import com.mubarak.tmdb.data.local.repository.OfflineItemsRepository
import com.mubarak.tmdb.domain.implementation.DetailsRepositoryImpl
import com.mubarak.tmdb.domain.implementation.MovieRepositoryImpl
import com.mubarak.tmdb.domain.implementation.PeopleRepositoryImpl
import com.mubarak.tmdb.domain.repository.IDetailsRepository
import com.mubarak.tmdb.domain.repository.IMovieRepository
import com.mubarak.tmdb.domain.repository.IPeopleRepository
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

    @Binds
    abstract fun bindOfflineRepository(offlineItemsRepository: OfflineItemsRepository): ItemsRepository
}