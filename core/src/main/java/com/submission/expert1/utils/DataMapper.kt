package com.submission.expert1.utils

import com.submission.expert1.data.source.local.entity.GamesEntity
import com.submission.expert1.data.source.remote.response.GamesResponse
import com.submission.expert1.domain.model.Games

object DataMapper {
    fun mapResponsesToEntities(input: List<GamesResponse>): List<GamesEntity> {
        val tourismList = ArrayList<GamesEntity>()
        input.map {
            val games = GamesEntity(
                gamesId = it.id,
                name = it.name,
                rating = it.rating,
                released = it.released,
                playtime = it.playtime,
                developers = it.developers,
                description = it.description,
                image = it.image,
                isFavorite = false
            )
            tourismList.add(games)
        }
        return tourismList
    }

    fun mapEntitiesToDomain(input: List<GamesEntity>): List<Games> =
        input.map {
            Games(
                gamesId = it.gamesId,
                name = it.name,
                rating = it.rating,
                released = it.released,
                playtime = it.playtime,
                developers = it.developers,
                description = it.description,
                image = it.image,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Games) = GamesEntity(
        gamesId = input.gamesId,
        description = input.description,
        name = input.name,
        rating = input.rating,
        released = input.released,
        playtime = input.playtime,
        developers = input.developers,
        image = input.image,
        isFavorite = input.isFavorite
    )
}