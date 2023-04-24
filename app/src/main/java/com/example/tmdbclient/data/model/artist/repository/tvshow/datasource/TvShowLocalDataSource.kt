package com.example.tmdbclient.data.model.artist.repository.tvshow.datasource

import com.example.tmdbclient.data.model.artist.Artist
import com.example.tmdbclient.data.model.movie.Movie
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.tvshow.TvShow
import retrofit2.Response

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDb(): List<TvShow>
    suspend fun saveTvShowsToDb(tvShows:List<TvShow>)
    suspend fun clearAll()

}