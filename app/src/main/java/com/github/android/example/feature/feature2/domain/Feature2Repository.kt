package com.github.android.example.feature.feature2.domain

import kotlinx.coroutines.flow.Flow

interface Feature2Repository {
    fun getObservableEvents(): Flow<Int>
}