package com.github.android.example.feature.main.domain

import com.github.android.shared.di.IoDispatcher
import com.github.android.shared.domain.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class SyncSomethingsUseCase @Inject constructor(
    private val appConfigRepository: AppConfigRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<Unit, Unit>(ioDispatcher) {

    override suspend fun execute(parameters: Unit) {
        appConfigRepository.syncSomethings()
    }
}