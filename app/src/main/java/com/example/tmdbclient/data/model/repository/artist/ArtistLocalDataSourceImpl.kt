package com.example.tmdbclient.data.model.repository.artist

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.artist.ArtistList
import com.example.tmdbclient.data.model.db.ArtistDao
import com.example.tmdbclient.data.model.db.MovieDao
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDb(): List<Artist> {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDb(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtists(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }


}