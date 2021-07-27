package com.github.android.example.feature.feature2.domain

import com.github.android.shared.Result
import com.github.android.shared.di.IoDispatcher
import com.github.android.shared.domain.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

open class GetObservableEventsUseCase @Inject constructor(
    private val feature2Repository: Feature2Repository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, Int>(ioDispatcher) {

    override fun execute(parameters: Unit): Flow<Result<Int>> {
        return feature2Repository.getObservableEvents().map {
            Result.Success(it)
        }
    }
}
