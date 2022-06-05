package com.vginert.rohlik.catalog.presentation.categories

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoriesRoute(
    navigator: CategoriesNavigator,
    viewModel: CategoriesViewModel = getViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    CategoriesScreen(
        uiSate = uiState,
        onCategoryClick = { categoryId -> navigator.goToProductsScreen(categoryId) }
    )
}
