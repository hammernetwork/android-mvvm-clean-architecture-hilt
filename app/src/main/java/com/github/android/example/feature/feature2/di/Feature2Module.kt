package com.github.android.example.feature.feature2.di

import com.github.android.example.feature.feature2.data.DefaultFeature2Repository
import com.github.android.example.feature.feature2.data.Feature2DataSource
import com.github.android.example.feature.feature2.data.RemoteFeature2DataSource
import com.github.android.example.feature.feature2.domain.Feature2Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface Feature2Module {

    @Singleton
    @Binds
    fun bindFeature2DataSource(dataSource: RemoteFeature2DataSource): Feature2DataSource

    @Singleton
    @Binds
    fun bindFeature2Repository(repository: DefaultFeature2Repository): Feature2Repository
}
