package com.example.tmdbclient.presentation.di.tvshow

import dagger.Subcomponent


@TvshowScope
@Subcomponent(modules = [TvShowModule::class])
interface TvShowSubComponent {
    fun inject(tvShowSubComponent: TvShowSubComponent)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvShowSubComponent
    }

}