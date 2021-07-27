package com.github.android.example.feature.main.data

import com.github.android.example.feature.main.domain.AppConfigRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultAppConfigRepository @Inject constructor(
    private val appConfigDataSource: AppConfigDataSource
) : AppConfigRepository {

    override suspend fun syncSomethings() {
        appConfigDataSource.syncSomethings()
    }
}