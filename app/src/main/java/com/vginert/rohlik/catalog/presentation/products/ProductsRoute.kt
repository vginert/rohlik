package com.vginert.rohlik.catalog.presentation.products

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun ProductsRoute(
    categoryId: String,
    navigator: ProductsNavigator,
    viewModel: ProductsViewModel = getViewModel { parametersOf(categoryId) }
) {
    val uiState by viewModel.uiState.collectAsState()
    
    ProductsScreen(
        uiState = uiState
    )
}
