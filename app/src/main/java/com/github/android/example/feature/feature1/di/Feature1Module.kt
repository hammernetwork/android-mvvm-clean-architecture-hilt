package com.github.android.example.feature.feature1.di

import com.github.android.example.feature.feature1.data.DefaultFeature1Repository
import com.github.android.example.feature.feature1.data.Feature1DataSource
import com.github.android.example.feature.feature1.data.RemoteFeature1DataSource
import com.github.android.example.feature.feature1.domain.Feature1Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal interface Feature1Module {

    @Singleton
    @Binds
    fun bindFeature1DataSource(dataSource: RemoteFeature1DataSource): Feature1DataSource

    @Singleton
    @Binds
    fun bindFeature1Repository(repository: DefaultFeature1Repository): Feature1Repository
}
