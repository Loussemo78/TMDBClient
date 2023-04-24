package com.example.tmdbclient.data.model.repository.artist

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCache(): List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)

}