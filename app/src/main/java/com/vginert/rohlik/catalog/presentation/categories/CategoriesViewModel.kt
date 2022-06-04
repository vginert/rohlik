package com.vginert.rohlik.catalog.presentation.categories

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CategoriesViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CategoriesState)
    val uiState: StateFlow<CategoriesState> = _uiState
}
