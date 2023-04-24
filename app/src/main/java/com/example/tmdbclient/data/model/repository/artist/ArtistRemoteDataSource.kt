package com.example.tmdbclient.data.model.repository.artist

import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}