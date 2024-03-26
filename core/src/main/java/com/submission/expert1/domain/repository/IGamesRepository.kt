package com.submission.expert1.domain.repository

import com.submission.expert1.data.Resource
import com.submission.expert1.domain.model.Games
import kotlinx.coroutines.flow.Flow

interface IGamesRepository {

    fun getAllGames(): Flow<Resource<List<Games>>>

    fun getFavoriteGames(): Flow<List<Games>>

    fun setFavoriteGames(games: Games, state: Boolean)

}