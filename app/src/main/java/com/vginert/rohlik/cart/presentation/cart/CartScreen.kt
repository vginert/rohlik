package com.vginert.rohlik.cart.presentation.cart

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.cart.presentation.cart.components.CartItemRow
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun CartScreen(
    uiState: CartState = CartState(),
    onCartItemRemoveClick: (cartItemId: String) -> Unit = {}
) {
    LazyColumn {
        uiState.cart.items.forEach { cartItem ->
            item(key = cartItem.id) {
                CartItemRow(
                    modifier = Modifier.fillMaxWidth(),
                    cartItem = cartItem,
                    onRemoveClick = onCartItemRemoveClick
                )
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
