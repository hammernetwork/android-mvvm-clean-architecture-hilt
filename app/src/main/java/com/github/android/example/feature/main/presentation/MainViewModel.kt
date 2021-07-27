package com.github.android.example.feature.main.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.android.example.feature.main.domain.SyncSomethingsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val syncSomethingsUseCase: SyncSomethingsUseCase,
) : ViewModel() {

    init {
        syncSomething()
    }

    private fun syncSomething() {
        viewModelScope.launch {
            syncSomethingsUseCase(Unit)
        }
    }

}