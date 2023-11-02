package com.mubarak.tmdb.data.di

import com.mubarak.tmdb.ui.commen.appPref.AppPrefs
import com.mubarak.tmdb.ui.commen.appPref.IAppPrefs
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppPrefsModule {

    @Singleton
    @Binds
    abstract fun bindAppPrefs(appPrefs: AppPrefs): IAppPrefs
}