package com.submission.expert1.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class GamesResponse(

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("background_image")
	val image: String,

	@field:SerializedName("description")
	val description: String,

	@field:SerializedName("released")
	val released: String,

	@field:SerializedName("rating")
	val rating: Double,

	@field:SerializedName("ratingCount")
	val ratingsCount: Int,

	@field:SerializedName("playtime")
	val playtime: Int,

	@field:SerializedName("developers")
	val developers: String

)