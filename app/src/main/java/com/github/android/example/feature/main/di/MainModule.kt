package com.github.android.example.feature.main.di

import com.github.android.example.feature.main.data.AppConfigDataSource
import com.github.android.example.feature.main.data.DefaultAppConfigRepository
import com.github.android.example.feature.main.data.RemoteAppConfigDataSource
import com.github.android.example.feature.main.domain.AppConfigRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface MainModule {

    @Singleton
    @Binds
    fun bindAppConfigDataSource(dataSource: RemoteAppConfigDataSource): AppConfigDataSource

    @Singleton
    @Binds
    fun bindAppConfigRepository(repository: DefaultAppConfigRepository): AppConfigRepository
}
