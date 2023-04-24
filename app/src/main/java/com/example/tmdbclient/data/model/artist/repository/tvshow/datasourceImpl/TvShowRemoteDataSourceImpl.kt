package com.example.tmdbclient.data.model.artist.repository.tvshow.datasourceImpl

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.tvshow.TvShowList
import retrofit2.Response

class TvShowRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TvShowList> {
        return tmdbService.getPopularTvShows(apiKey)
    }
}