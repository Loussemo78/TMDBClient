package com.example.tmdbclient.presentation.tv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tmdbclient.domain.usecase.GetTvShowsUseCase
import com.example.tmdbclient.domain.usecase.UpdateTvShowsUseCase

class TvShowViewModel(
   private val getTvShowsUseCase: GetTvShowsUseCase,
   private val updateTvShowsUseCase: UpdateTvShowsUseCase
):ViewModel() {

    fun getTvShows() = liveData {
        val tvShowlist = getTvShowsUseCase.execute()
        emit(tvShowlist)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowsUseCase.execute()
        emit(tvShowList)
    }
}