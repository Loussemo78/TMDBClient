package com.example.tmdbclient.presentation.di.core

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.model.artist.repository.artist.datasourceImpl.ArtistRemoteDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasourceImpl.MovieRemoteDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasourceImpl.TvShowRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDatasource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvRemoteDatasource(tmdbService: TMDBService):TvShowRemoteDataSource{
        return TvShowRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDatasource(tmdbService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImpl(
            tmdbService, apiKey
        )
    }

}