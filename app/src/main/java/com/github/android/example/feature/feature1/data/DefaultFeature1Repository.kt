package com.github.android.example.feature.feature1.data

import com.github.android.example.feature.feature1.domain.Feature1Repository
import com.github.android.shared.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultFeature1Repository @Inject constructor(
    private val appConfigDataSource: Feature1DataSource
) : Feature1Repository {

    override suspend fun recordSomething(): Result<Unit> {
        return appConfigDataSource.recordSomething()
    }

    override fun getStatus(): String {
        return appConfigDataSource.getStatus()
    }
}