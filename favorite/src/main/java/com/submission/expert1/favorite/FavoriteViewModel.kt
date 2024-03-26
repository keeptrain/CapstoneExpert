package com.submission.expert1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.expert1.domain.usecase.GamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(gamesUseCase: GamesUseCase): ViewModel() {
    val favoriteGames = gamesUseCase.getFavoriteGames().asLiveData()
}

