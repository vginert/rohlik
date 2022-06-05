package com.vginert.rohlik.catalog.presentation.product_details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ProductDetailsRoute(
    productId: String,
    viewModel: ProductDetailsViewModel = getViewModel { parametersOf(productId) }
) {
    val uiState by viewModel.uiState.collectAsState()

    ProductDetailsScreen(
        uiState = uiState
    )
}
