package com.submission.expert1.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "games")
data class GamesEntity(

    @PrimaryKey
    @ColumnInfo(name = "gamesId")
    var gamesId: Int?,

    @ColumnInfo(name = "name")
    var name: String?,

    @ColumnInfo(name = "rating")
    var rating: Double?,

    @ColumnInfo(name = "released")
    var released: String?,

    @ColumnInfo(name = "description")
    var description: String?,

    @ColumnInfo(name = "image")
    var image: String?,

    @ColumnInfo(name = "playtime")
    var playtime: Int?,

    @ColumnInfo(name = "developers")
    var developers: String?,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)