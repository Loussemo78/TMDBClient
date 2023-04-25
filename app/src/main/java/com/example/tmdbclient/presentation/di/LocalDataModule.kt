package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import com.example.tmdbclient.data.model.db.ArtistDao
import com.example.tmdbclient.data.model.db.MovieDao
import com.example.tmdbclient.data.model.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }
}
