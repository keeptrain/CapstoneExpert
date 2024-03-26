package com.submission.expert1.di

import com.submission.expert1.domain.usecase.GamesUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface FavoriteModuleDependencies {

    fun provideGamesUseCase(): GamesUseCase
}