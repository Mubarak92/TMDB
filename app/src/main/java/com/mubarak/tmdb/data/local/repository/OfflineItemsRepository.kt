package com.mubarak.tmdb.data.local.repository

import com.mubarak.tmdb.data.db.AppDataBase
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflineItemsRepository @Inject constructor(db: AppDataBase) : ItemsRepository {

    private val movieDao = db.movieDao()

    override fun getAllItemsStream(): Flow<List<MovieItem>> = movieDao.getAllMovies()

    override fun getItemStream(id: Int): Flow<MovieItem?> = movieDao.getItem(id)

    override suspend fun insertItem(item: MovieItem?) = movieDao.insert(item)

    override suspend fun deleteItem(item: MovieItem) = movieDao.delete(item)
}
