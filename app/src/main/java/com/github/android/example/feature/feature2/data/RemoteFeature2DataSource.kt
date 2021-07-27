package com.github.android.example.feature.feature2.data

import com.github.android.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

interface Feature2DataSource {

    fun getObservableEvents(): Flow<Int>
}

@ExperimentalCoroutinesApi
class RemoteFeature2DataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Feature2DataSource {

    override fun getObservableEvents(): Flow<Int> = callbackFlow {
        repeat(1000) {
            delay(500)
            trySend(it)
        }

        awaitClose {
            // clean resources here
        }
    }.flowOn(ioDispatcher)
}
