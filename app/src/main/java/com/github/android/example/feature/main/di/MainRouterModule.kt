package com.github.android.example.feature.main.di

import com.github.android.example.feature.main.presentation.DefaultMainRouter
import com.github.android.example.feature.main.presentation.MainRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
internal interface MainRouterModule {

    @ActivityScoped
    @Binds
    fun bindRouter(router: DefaultMainRouter): MainRouter
}
