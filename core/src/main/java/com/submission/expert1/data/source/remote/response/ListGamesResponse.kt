package com.submission.expert1.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(

	@field:SerializedName("count")
	val count: Int?,

	@field:SerializedName("next")
	val next: String?,

	@field:SerializedName("previous")
	val previous: String?,

	@field:SerializedName("results")
	val results: ArrayList<GamesResponse> = arrayListOf(),

	@field:SerializedName("description")
	val description: String?

)

