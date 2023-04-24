package com.example.tmdbclient.data.model.repository.artist

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmdbService.getPopularArtists(apiKey)
    }
}