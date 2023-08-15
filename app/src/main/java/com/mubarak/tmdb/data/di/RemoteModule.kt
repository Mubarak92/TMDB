package com.mubarak.tmdb.data.di

import com.mubarak.tmdb.data.network.remote.implementation.DetailsRemoteImpl
import com.mubarak.tmdb.data.network.remote.IDetailsRemote
import com.mubarak.tmdb.data.network.remote.IMovieRemote
import com.mubarak.tmdb.data.network.remote.implementation.MovieRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteModule {

    @Binds
    abstract fun bindMovieRemote(movieRemoteImpl: MovieRemoteImpl): IMovieRemote

    @Binds
    abstract fun bindDetailsRemote(detailsRemoteImpl: DetailsRemoteImpl): IDetailsRemote
}