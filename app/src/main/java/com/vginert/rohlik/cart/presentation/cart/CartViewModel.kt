package com.vginert.rohlik.cart.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vginert.rohlik.cart.presentation.cart.models.CartModel
import com.vginert.rohlik.cart.presentation.cart.models.asPresentation
import com.vginert.rohlik.shared.core.coroutines.executeUseCase
import com.vginert.rohlik.shared.domain.use_cases.ClearCartUseCase
import com.vginert.rohlik.shared.domain.use_cases.RemoveProductFromCartUseCase
import com.vginert.rohlik.shared.domain.use_cases.SubscribeToCartUseCase
import com.vginert.rohlik.shared.presentation.models.asDomain
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CartViewModel(
    private val subscribeToCartUseCase: SubscribeToCartUseCase,
    private val removeProductFromCartUseCase: RemoveProductFromCartUseCase,
    private val clearCartUseCase: ClearCartUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CartState())
    val uiState: StateFlow<CartState> = _uiState

    init {
        subscribeToCartChanges()
    }

    fun onCartItemRemoveClick(item: CartModel.Item) = viewModelScope.launch {
        executeUseCase { removeProductFromCartUseCase(item.product.asDomain()) }
            .onFailure(::onRemoveProductFromCartFail)
    }

    fun onClearCartClick() = viewModelScope.launch {
        executeUseCase { clearCartUseCase() }
            .onFailure(::onClearCartFail)
    }

    private fun subscribeToCartChanges() = viewModelScope.launch {
        subscribeToCartUseCase().collect { cart ->
            _uiState.update { state ->
                state.copy(cart = cart.asPresentation())
            }
        }
    }

    private fun onClearCartFail(error: Throwable) {
        TODO()
    }

    private fun onRemoveProductFromCartFail(error: Throwable) {
        TODO()
    }
}
