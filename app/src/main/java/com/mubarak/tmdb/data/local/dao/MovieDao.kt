package com.mubarak.tmdb.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mubarak.tmdb.data.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Singleton

@Dao
interface MovieDao {

    @Query("SELECT * from movie_table ORDER BY title ASC")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * from movie_table WHERE id = :id")
    fun getItem(id: Int): Flow<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(item: MovieEntity)

    @Delete
    suspend fun delete(item: MovieEntity)
}