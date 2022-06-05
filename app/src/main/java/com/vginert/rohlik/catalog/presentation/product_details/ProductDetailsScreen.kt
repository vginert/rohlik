package com.vginert.rohlik.catalog.presentation.product_details

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun ProductDetailsScreen(
    uiState: ProductDetailsState = ProductDetailsState()
) {
    uiState.productDetails?.let { Text(text = it.name) }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailsScreenPreview() {
    RohlikTheme {
        ProductDetailsScreen()
    }
}
