package com.mubarak.tmdb.data.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [

    ],
    version = 1
)

abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "appDataBase.db"
    }
}