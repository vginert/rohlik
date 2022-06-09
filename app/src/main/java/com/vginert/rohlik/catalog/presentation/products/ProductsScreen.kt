@file:OptIn(ExperimentalFoundationApi::class)

package com.vginert.rohlik.catalog.presentation.products

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vginert.rohlik.R
import com.vginert.rohlik.catalog.presentation.products.components.ProductItem
import com.vginert.rohlik.shared.presentation.compose.ShowGenericError
import com.vginert.rohlik.shared.presentation.models.ProductModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing

@Composable
fun ProductsScreen(
    uiState: ProductsState = ProductsState(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onProductClick: (product: ProductModel) -> Unit = {},
    onAddToCartClick: (product: ProductModel) -> Unit = {},
    onGoToCartClick: () -> Unit = {},
    onGenericErrorDismissed: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = uiState.title) },
                actions = {
                    IconButton(onClick = onGoToCartClick) {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(id = R.string.go_to_cart_button)
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyVerticalGrid(
                modifier = Modifier.fillMaxSize(),
                cells = GridCells.Adaptive(minSize = 200.dp),
                contentPadding = PaddingValues(all = Spacing.S)
            ) {
                uiState.products.forEach { product ->
                    item {
                        Box(modifier = Modifier.padding(Spacing.S)) {
                            ProductItem(
                                modifier = Modifier.fillMaxWidth(),
                                product = product,
                                onClick = onProductClick,
                                onAddToCartClick = onAddToCartClick,
                            )
                        }
                    }
                }
            }

            if (uiState.showContentNotFound) {
                Column(modifier = Modifier.align(Alignment.Center)) {
                    Icon(
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .size(60.dp),
                        imageVector = Icons.Filled.Warning,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.height(Spacing.L))
                    Text(
                        text = stringResource(id = R.string.category_not_found),
                        textAlign = TextAlign.Center
                    )
                }
            }

            if (uiState.isLoadingContent) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    if (uiState.showGenericError) {
        scaffoldState.ShowGenericError { onGenericErrorDismissed() }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsScreenPreview() {
    RohlikTheme {
        ProductsScreen(
            uiState = ProductsState(showContentNotFound = true)
        )
    }
}
