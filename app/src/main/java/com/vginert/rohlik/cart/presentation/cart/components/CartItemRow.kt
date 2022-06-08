package com.vginert.rohlik.cart.presentation.cart.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.cart.presentation.cart.models.CartModel
import com.vginert.rohlik.shared.presentation.models.PriceModel
import com.vginert.rohlik.shared.presentation.models.ProductModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing
import java.util.*

@Composable
fun CartItemRow(
    modifier: Modifier = Modifier,
    cartItem: CartModel.Item,
    onRemoveClick: (cartItem: CartModel.Item) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = { onRemoveClick(cartItem) }
            )
            .padding(horizontal = Spacing.M, vertical = Spacing.S)
    ) {
        Text(text = cartItem.product.name)
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemRowPreview() {
    val cartItem = CartModel.Item(
        product = ProductModel(
            id = UUID.randomUUID().toString(),
            name = "Cola",
            price = PriceModel(1.2, Currency.getInstance("EUR")),
            imageUrl = ""
        ),
        amount = 2
    )
    RohlikTheme {
        CartItemRow(cartItem = cartItem)
    }
}

