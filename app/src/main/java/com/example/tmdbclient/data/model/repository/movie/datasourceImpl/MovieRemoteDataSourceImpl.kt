package com.example.tmdbclient.data.model.repository.movie.datasourceImpl

import com.example.tmdbclient.data.model.api.TMDBService
import com.example.tmdbclient.data.model.movie.MovieList
import com.example.tmdbclient.data.model.repository.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl(
    private val tmdbService: TMDBService,
    private val apiKey:String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmdbService.getPopularMovies(apiKey)
    }
}