package com.submission.expert1.data.source

import com.submission.expert1.data.NetworkBoundResource
import com.submission.expert1.data.Resource
import com.submission.expert1.data.source.local.LocalDataSource
import com.submission.expert1.data.source.remote.RemoteDataSource
import com.submission.expert1.data.source.remote.network.ApiResponse
import com.submission.expert1.data.source.remote.response.GamesResponse
import com.submission.expert1.domain.model.Games
import com.submission.expert1.domain.repository.IGamesRepository
import com.submission.expert1.utils.AppExecutors
import com.submission.expert1.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GamesRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IGamesRepository {
    override fun getAllGames(): Flow<Resource<List<Games>>> =
        object : NetworkBoundResource<List<Games>, List<GamesResponse>>() {
            override fun loadFromDB(): Flow<List<Games>> {
                return localDataSource.getAllGames().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override suspend fun createCall(): Flow<ApiResponse<List<GamesResponse>>> = remoteDataSource.getAllGames()

            override suspend fun saveCallResult(data: List<GamesResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertGames(movieList)
            }

            override fun shouldFetch(data: List<Games>?): Boolean = data.isNullOrEmpty()
        }.asFlow()


    override fun getFavoriteGames(): Flow<List<Games>> {
        return localDataSource.getFavoriteGames().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteGames (games: Games, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(games)
        appExecutors.diskIO().execute { localDataSource.setFavoriteGames(movieEntity, state) }
    }


}