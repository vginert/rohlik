package com.vginert.rohlik.cart.presentation.cart.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import com.vginert.rohlik.cart.presentation.cart.models.CartModel
import com.vginert.rohlik.shared.presentation.theme.Spacing

@Composable
fun CartItemRow(
    modifier: Modifier = Modifier,
    cartItem: CartModel.Item,
    onRemoveClick: (cartItemId: String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = { onRemoveClick(cartItem.id) }
            )
            .padding(horizontal = Spacing.M, vertical = Spacing.S)
    ) {
        Text(text = cartItem.name)
    }
}
