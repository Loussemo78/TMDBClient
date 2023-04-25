package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvShowCacheDataSource{
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }
}