package com.vginert.rohlik.catalog.presentation.products

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.catalog.presentation.products.components.ProductRow
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun ProductsScreen(
    uiState: ProductsState = ProductsState(),
    onProductClick: (id: String) -> Unit = {}
) {
    LazyColumn {
        uiState.products.forEach { product ->
            item(key = product.id) {
                ProductRow(
                    modifier = Modifier.fillMaxWidth(),
                    product = product,
                    onClick = onProductClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    RohlikTheme {
        ProductsScreen()
    }
}
