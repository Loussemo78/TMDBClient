package com.example.tmdbclient.data.model.repository.artist

import android.util.Log
import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieLocalDataSource
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import com.example.tmdbclient.domain.repository.ArtistRepository
import com.example.tmdbclient.domain.repository.MovieRepository

class ArtistRepositoryImpl(
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
): ArtistRepository {

    override suspend fun getArtists(): List<Artist>? {
        return getArtistsFromCache()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtist = getArtistsFromAPI()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDb(newListOfArtist)
        artistCacheDataSource.saveArtistsToCache(newListOfArtist)
        return newListOfArtist
    }

    suspend fun getArtistsFromAPI():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
          val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body!= null){
                artistList = body.artists
            }

        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return artistList
    }

    suspend fun getArtistsFromDB():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistLocalDataSource.getArtistsFromDb()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromAPI()
            artistLocalDataSource.saveArtistsToDb(artistList)
        }
        return artistList

    }

    suspend fun getArtistsFromCache():List<Artist>{
        lateinit var artistList:List<Artist>
        try{
            artistList = artistCacheDataSource.getArtistsFromCache()
        }catch (exception:Exception){
            Log.i("MyTag", exception.message.toString())
        }
        if (artistList.size > 0){
            return artistList
        }else{
            artistList = getArtistsFromDB()
            artistCacheDataSource.saveArtistsToCache(artistList)
        }
        return artistList

    }



}