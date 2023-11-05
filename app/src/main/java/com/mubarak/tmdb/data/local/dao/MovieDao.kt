package com.mubarak.tmdb.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mubarak.tmdb.domain.model.movieModel.MovieItem
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * from movies_table ORDER BY title ASC")
    fun getAllMovies(): Flow<List<MovieItem>>

    @Query("SELECT * from movies_table WHERE id = :id")
    fun getItem(id: Int): Flow<MovieItem>

    @Query("SELECT EXISTS (SELECT 1 FROM movies_table WHERE id = :id)")
    fun isExists(id: Int): Flow<Boolean>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: MovieItem?)

    @Delete
    suspend fun delete(item: MovieItem)
}