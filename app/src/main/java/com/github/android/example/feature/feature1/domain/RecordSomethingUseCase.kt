package com.github.android.example.feature.feature1.domain

import com.github.android.shared.di.IoDispatcher
import com.github.android.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class RecordSomethingUseCase @Inject constructor(
    private val repository: Feature1Repository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Unit) {
        repository.recordSomething()
    }
}