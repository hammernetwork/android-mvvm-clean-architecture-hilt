package com.github.android.example.feature.feature1.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.android.example.feature.feature1.domain.GetStatusUseCase
import com.github.android.example.feature.feature1.domain.RecordSomethingUseCase
import com.github.android.shared.Result
import com.github.android.shared.presentation.WhileViewSubscribed
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class Screen1ViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getStatusUseCase: GetStatusUseCase,
    private val recordSomethingUseCase: RecordSomethingUseCase,
) : ViewModel() {

//    private val loadingProcess = MutableSharedFlow<Screen1ButtonUiModel>()
//    val buttonUiState: StateFlow<Screen1ButtonUiModel> = loadingProcess
////        emit(Screen1ButtonUiModel(isLoading = false))
////        emitAll(loadingProcess)
////    }
//        .stateIn(viewModelScope, WhileViewSubscribed, Screen1ButtonUiModel(isLoading = false))

    private val _buttonUiState =
        MutableStateFlow<Screen1ButtonUiModel>(Screen1ButtonUiModel(isLoading = false))
    val buttonUiState: StateFlow<Screen1ButtonUiModel> = _buttonUiState


    val status: StateFlow<String> = flow {
        val result = getStatusUseCase(Unit)
        if (result is Result.Success) {
            emit(result.data)
        }
    }.stateIn(viewModelScope, WhileViewSubscribed, initialValue = "")

    fun recordSomething() {
        _buttonUiState.value = Screen1ButtonUiModel(isLoading = true)
        viewModelScope.launch {
            recordSomethingUseCase(Unit)

            _buttonUiState.value = Screen1ButtonUiModel(isLoading = false)
        }
    }
}

data class Screen1ButtonUiModel(
    val isLoading: Boolean = false,
)
