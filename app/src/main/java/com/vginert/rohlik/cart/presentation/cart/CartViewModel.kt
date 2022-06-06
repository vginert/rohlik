package com.vginert.rohlik.cart.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.cart.domain.use_cases.SubscribeToCartUseCase
import com.vginert.rohlik.cart.presentation.cart.models.asPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(
    private val subscribeToCartUseCase: SubscribeToCartUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(CartState())
    val uiState: StateFlow<CartState> = _uiState

    init {
        subscribeToCartChanges()
    }

    fun onCartItemRemoveClick(itemId: String) {
        // TODO
    }

    private fun subscribeToCartChanges() = viewModelScope.launch {
        subscribeToCartUseCase().collect { cart ->
            _uiState.update { state ->
                state.copy(cart = cart.asPresentation())
            }
        }
    }
}
