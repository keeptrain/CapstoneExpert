package com.submission.expert1.data.source.remote

import android.util.Log
import com.submission.expert1.core.BuildConfig
import com.submission.expert1.data.source.remote.network.ApiResponse
import com.submission.expert1.data.source.remote.network.ApiService
import com.submission.expert1.data.source.remote.response.GamesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllGames(): Flow<ApiResponse<List<GamesResponse>>> {
        return flow {
            try {
                val key = BuildConfig.API_KEY
                val response = apiService.getList(key)
                val dataArray = response.results
                if (dataArray.isNotEmpty()){
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}