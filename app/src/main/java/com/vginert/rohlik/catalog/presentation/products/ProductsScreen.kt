@file:OptIn(ExperimentalFoundationApi::class)

package com.vginert.rohlik.catalog.presentation.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vginert.rohlik.catalog.presentation.products.components.ProductItem
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing

@Composable
fun ProductsScreen(
    uiState: ProductsState = ProductsState(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onProductClick: (id: String) -> Unit = {}
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text(text = uiState.title) }) },
        scaffoldState = scaffoldState,
    ) {
        LazyVerticalGrid(
            cells = GridCells.Adaptive(minSize = 200.dp),
            contentPadding = PaddingValues(all = Spacing.S)
        ) {
            uiState.products.forEach { product ->
                item {
                    Box(modifier = Modifier.padding(Spacing.S)) {
                        ProductItem(
                            modifier = Modifier.fillMaxWidth(),
                            product = product,
                            onClick = onProductClick
                        )
                    }
                }
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
