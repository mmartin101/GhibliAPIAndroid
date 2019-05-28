package com.mmartin.ghibliapi.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mmartin.ghibliapi.data.model.Film
import com.mmartin.ghibliapi.data.model.FilmDao

@Database(entities = [Film::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}