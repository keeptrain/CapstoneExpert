package com.submission.expert1.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.submission.expert1.domain.usecase.GamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(gamesUseCase: GamesUseCase) : ViewModel() {
    val games = gamesUseCase.getAllGames().asLiveData()
}