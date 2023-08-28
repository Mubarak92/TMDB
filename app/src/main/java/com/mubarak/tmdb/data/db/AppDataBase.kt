package com.mubarak.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mubarak.tmdb.data.local.dao.MovieDao
import com.mubarak.tmdb.data.local.entities.MovieEntity

@Database(
    entities = [
        MovieEntity::class
    ],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        const val DB_NAME = "appDataBase.db"
    }
}