package com.submission.expert1.detail

import androidx.lifecycle.ViewModel
import com.submission.expert1.domain.model.Games
import com.submission.expert1.domain.usecase.GamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailGamesViewModel @Inject constructor(private val gamesUseCase: GamesUseCase) : ViewModel() {

    fun setFavoriteGames(games: Games, newStatus:Boolean) =
        gamesUseCase.setFavoriteGames(games , newStatus)
}