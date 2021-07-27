package com.github.android.example.feature.feature2.data

import com.github.android.example.feature.feature2.domain.Feature2Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefaultFeature2Repository @Inject constructor(
    private val dataSource: Feature2DataSource
) : Feature2Repository {

    override fun getObservableEvents(): Flow<Int> {
        return dataSource.getObservableEvents()
//            .map { event ->
//                Result.success(event)
//            }.catch { e ->
//                Result.failure<Int>(e)
//            }
    }
}