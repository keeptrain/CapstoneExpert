package com.submission.expert1.data.source.remote.network

import com.submission.expert1.data.source.remote.response.ListGameResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("games")
    suspend fun getList(
        @Query("key") key: String,
    ): ListGameResponse

}