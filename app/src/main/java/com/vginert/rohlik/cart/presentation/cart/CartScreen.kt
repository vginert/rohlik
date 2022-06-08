package com.vginert.rohlik.cart.presentation.cart

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.R
import com.vginert.rohlik.cart.presentation.cart.components.CartItemRow
import com.vginert.rohlik.cart.presentation.cart.models.CartModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun CartScreen(
    uiState: CartState = CartState(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onCartItemRemoveClick: (cartItem: CartModel.Item) -> Unit = {},
    onClearCartClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.cart_title)) },
                actions = {
                    IconButton(onClick = onClearCartClick) {
                        Icon(
                            Icons.Filled.Delete,
                            contentDescription = stringResource(id = R.string.clear_cart_button)
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
    ) {
        LazyColumn {
            uiState.cart.items.forEach { cartItem ->
                item(key = cartItem.product.id) {
                    CartItemRow(
                        modifier = Modifier.fillMaxWidth(),
                        cartItem = cartItem,
                        onRemoveClick = onCartItemRemoveClick
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    RohlikTheme {
        CartScreen()
    }
}
