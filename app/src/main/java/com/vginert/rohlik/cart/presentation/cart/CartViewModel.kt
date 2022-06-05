package com.vginert.rohlik.cart.presentation.cart

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CartViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CartState)
    val uiState: StateFlow<CartState> = _uiState
}
