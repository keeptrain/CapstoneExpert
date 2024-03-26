package com.submission.expert1.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Games(
    val gamesId: Int?,
    val name: String?,
    val rating: Double?,
    val released: String?,
    val playtime: Int?,
    val developers: String?,
    val description: String?,
    val image: String?,
    val isFavorite: Boolean
): Parcelable
