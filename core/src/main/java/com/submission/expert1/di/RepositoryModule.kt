package com.submission.expert1.di

import com.submission.expert1.data.source.GamesRepository
import com.submission.expert1.domain.repository.IGamesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [DatabaseModule::class, NetworkModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideGamesRepository(gamesRepository: GamesRepository) : IGamesRepository

}