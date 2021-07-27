package com.github.android.example.feature.feature1.data

import com.github.android.shared.Result
import com.github.android.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.resume

interface Feature1DataSource {

    suspend fun recordSomething(): Result<Unit>
    fun getStatus(): String
}

class RemoteFeature1DataSource @Inject constructor(
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : Feature1DataSource {

    override suspend fun recordSomething(): Result<Unit> = withContext(ioDispatcher) {
        delay(3000)
        // The suspendCancellableCoroutine method suspends a coroutine manually. With the
        // continuation object you receive in the lambda, you can resume the coroutine
        // after the work is done.
        suspendCancellableCoroutine { continuation ->
            // recording...
            continuation.resume(Result.Success(Unit))
            // or if error
            //  continuation.resume(Result.failure( Exception("Error!")))
        }
    }

    override fun getStatus(): String = "Ready"

}
