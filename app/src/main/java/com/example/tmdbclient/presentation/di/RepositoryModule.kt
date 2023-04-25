package com.example.tmdbclient.presentation.di

import com.example.tmdbclient.data.model.artist.repository.ArtistRepositoryImpl
import com.example.tmdbclient.data.model.artist.repository.MovieRepositoryImpl
import com.example.tmdbclient.data.model.artist.repository.TvShowRepositoryImpl
import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.artist.datasource.ArtistRemoteDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowCacheDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowLocalDataSource
import com.example.tmdbclient.data.model.artist.repository.tvshow.datasource.TvShowRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository
import com.example.tmdbclient.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource

        ): TvShowRepository {
        return TvShowRepositoryImpl(
            tvShowRemoteDataSource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }

    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource

        ): ArtistRepository {
        return ArtistRepositoryImpl(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }
}