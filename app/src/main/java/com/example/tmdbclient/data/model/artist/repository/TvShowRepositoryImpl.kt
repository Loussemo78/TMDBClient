package com.example.tmdbclient.data.model.artist.repository

import android.util.Log
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.tvshow.TvShow
import com.example.tmdbclient.domain.repository.TvShowRepository

class TvShowRepositoryImpl(
    private val tvShowRemoteDataSource: TvShowRemoteDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowCacheDataSource: TvShowCacheDataSource
): TvShowRepository {

    override suspend fun getTvShows(): List<TvShow>? {
        return getTvshowsFromCache()
    }

    override suspend fun updateTvShows(): List<TvShow>? {
        val newListOfTvShow = getTvShowsFromAPI()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDb(newListOfTvShow)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShow)
        return newListOfTvShow
    }

    suspend fun getTvShowsFromAPI():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
          val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body!= null){
                tvShowList = body.tvShows
            }

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return tvShowList
    }

    suspend fun getTvShowsFromDB():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList = tvShowLocalDataSource.getTvShowsFromDb()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromAPI()
            tvShowLocalDataSource.saveTvShowsToDb(tvShowList)
        }
        return tvShowList

    }

    suspend fun getTvshowsFromCache():List<TvShow>{
        lateinit var tvShowList:List<TvShow>
        try{
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (tvShowList.size > 0){
            return tvShowList
        }else{
            tvShowList = getTvShowsFromDB()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }



}