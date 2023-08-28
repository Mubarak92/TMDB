package com.mubarak.tmdb.data.local.repository

import com.mubarak.tmdb.data.db.AppDataBase
import com.mubarak.tmdb.data.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OfflineItemsRepository @Inject constructor(db: AppDataBase) : ItemsRepository {

    private val movieDao = db.movieDao()

    override fun getAllItemsStream(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    override fun getItemStream(id: Int): Flow<MovieEntity?> = movieDao.getItem(id)

    override suspend fun insertItem(item: MovieEntity) = movieDao.insert(item)

    override suspend fun deleteItem(item: MovieEntity) = movieDao.delete(item)
}
