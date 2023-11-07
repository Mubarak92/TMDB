package com.mubarak.tmdb.data.local.repository

import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import kotlinx.coroutines.flow.Flow

interface ItemsRepository {
    fun getAllItemsStream(): Flow<List<MovieItem>>
    fun getItemStream(id: Int): Flow<MovieItem?>
    fun isExists(id: Int): Flow<Boolean>
    suspend fun insertItem(item: MovieItem?)
    suspend fun deleteItem(item: MovieItem)
}
