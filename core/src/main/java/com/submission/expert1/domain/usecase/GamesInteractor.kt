package com.submission.expert1.domain.usecase

import com.submission.expert1.domain.model.Games
import com.submission.expert1.domain.repository.IGamesRepository
import javax.inject.Inject

class GamesInteractor @Inject constructor(private val gameRepository: IGamesRepository): GamesUseCase {

    override fun getAllGames() = gameRepository.getAllGames()

    override fun getFavoriteGames() = gameRepository.getFavoriteGames()

    override fun setFavoriteGames(games: Games, state: Boolean) = gameRepository.setFavoriteGames(games,state)

}

