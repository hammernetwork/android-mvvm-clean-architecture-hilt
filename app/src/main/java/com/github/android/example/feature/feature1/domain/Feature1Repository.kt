package com.github.android.example.feature.feature1.domain

import com.github.android.shared.Result

interface Feature1Repository {
    suspend fun recordSomething(): Result<Unit>
    fun getStatus(): String
}