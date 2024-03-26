package com.submission.expert1.data.source.local

import com.submission.expert1.data.source.local.entity.GamesEntity
import com.submission.expert1.data.source.local.room.GamesDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource  @Inject constructor(private val gamesDao: GamesDao) {

    fun getAllGames(): Flow<List<GamesEntity>> = gamesDao.getAllGames()

    fun getFavoriteGames(): Flow<List<GamesEntity>> = gamesDao.getFavoriteGames()

    suspend fun insertGames(gamesList: List<GamesEntity>) = gamesDao.insertGames(gamesList)

    fun setFavoriteGames(games: GamesEntity, newState: Boolean) {
        games.isFavorite = newState
        gamesDao.updateFavoriteGames(games)
    }
}