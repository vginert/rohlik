package com.vginert.rohlik.shared.presentation.lifecycle

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.shared.core.coroutines.executeUseCase

suspend inline fun <R> ViewModel.executeUseCase(block: () -> R): Result<R> {
    return viewModelScope.executeUseCase(block)
}
