package com.github.android.example.feature.main.data

import com.github.android.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface AppConfigDataSource {

    suspend fun syncSomethings()
}

class RemoteAppConfigDataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : AppConfigDataSource {

    override suspend fun syncSomethings() {
        withContext(ioDispatcher) {
            delay(1000)
        }
    }
}
