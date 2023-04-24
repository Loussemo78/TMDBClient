package com.example.tmdbclient.data.model.artist.repository.artist.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDb(): List<Artist>
    suspend fun saveArtistsToDb(artists:List<Artist>)
    suspend fun clearAll()

}