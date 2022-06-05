package com.vginert.rohlik.cart.presentation.cart

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun CartScreen(
    uiState: CartState = CartState
) {
    Text(text = "Cart")
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    RohlikTheme {
        CartScreen()
    }
}
