package com.example.tmdbclient.data.model.artist.repository.movie.datasourceImpl

import com.example.tmdbclient.data.model.artist.repository.movie.datasource.MovieCacheDataSource
import com.example.tmdbclient.data.model.movie.Movie

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
       return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}