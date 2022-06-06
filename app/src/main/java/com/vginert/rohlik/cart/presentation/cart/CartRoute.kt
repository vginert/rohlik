package com.vginert.rohlik.cart.presentation.cart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun CartRoute(
    viewModel: CartViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CartScreen(
        uiState = uiState,
        onCartItemRemoveClick = viewModel::onCartItemRemoveClick
    )
}
