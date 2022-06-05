package com.vginert.rohlik.catalog.presentation.products

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ProductsViewModel(
    private val categoryId: String
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProductsState(categoryId))
    val uiState: StateFlow<ProductsState> = _uiState
}
