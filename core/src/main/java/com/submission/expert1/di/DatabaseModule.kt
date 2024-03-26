package com.submission.expert1.di

import android.content.Context
import androidx.room.Room
import com.submission.expert1.data.source.local.room.GamesDao
import com.submission.expert1.data.source.local.room.GamesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    private val passphrase = SQLiteDatabase.getBytes("games".toCharArray())
    private val factory = SupportFactory(passphrase)

    @Provides
    @Singleton
    fun provideGamesDatabase(@ApplicationContext context: Context): GamesDatabase = Room.databaseBuilder(
        context,
        GamesDatabase::class.java, "games.db"
    ).fallbackToDestructiveMigration().openHelperFactory(factory).build()

    @Provides
    fun provideGamesDao(gamesDatabase : GamesDatabase): GamesDao {
        return gamesDatabase.gamesDao()
    }

}