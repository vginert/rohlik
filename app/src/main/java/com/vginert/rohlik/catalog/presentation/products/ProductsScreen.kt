package com.vginert.rohlik.catalog.presentation.products

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun ProductsScreen(
    uiState: ProductsState = ProductsState()
) {
    Text(text = uiState.categoryId)
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    RohlikTheme {
        ProductsScreen()
    }
}
