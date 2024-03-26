package com.submission.expert1.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.submission.expert1.domain.usecase.GamesUseCase
import javax.inject.Inject

class ViewModelFactory @Inject constructor(
    private val gamesUseCase: GamesUseCase) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T = when {
        modelClass.isAssignableFrom(FavoriteViewModel::class.java) -> {
            FavoriteViewModel(gamesUseCase) as T
        }
        else -> throw IllegalArgumentException("unknown model class $modelClass")
    }
}