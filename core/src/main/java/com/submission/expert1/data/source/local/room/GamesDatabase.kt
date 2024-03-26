package com.submission.expert1.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.submission.expert1.data.source.local.entity.GamesEntity

@Database(entities = [GamesEntity::class], version = 3, exportSchema = false)
abstract class GamesDatabase : RoomDatabase() {
    abstract fun gamesDao(): GamesDao
}