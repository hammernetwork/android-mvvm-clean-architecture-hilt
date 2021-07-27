package com.github.android.example.feature.feature2.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.android.example.feature.feature2.domain.GetObservableEventsUseCase
import com.github.android.shared.Result
import com.github.android.shared.presentation.WhileViewSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class Screen2ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getObservableEventsUseCase: GetObservableEventsUseCase,
) : ViewModel() {

    val events: StateFlow<Int> = flow {
        getObservableEventsUseCase(Unit)
            .collect { result ->
                if (result is Result.Success) {
                    emit(result.data)
                }
            }
    }.stateIn(viewModelScope, WhileViewSubscribed, initialValue = 0)

}