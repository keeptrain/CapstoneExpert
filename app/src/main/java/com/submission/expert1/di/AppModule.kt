package com.submission.expert1.di

import com.submission.expert1.domain.usecase.GamesInteractor
import com.submission.expert1.domain.usecase.GamesUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideGamesUseCase(gamesInteractor: GamesInteractor): GamesUseCase

}
