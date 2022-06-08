package com.vginert.rohlik.cart.presentation.cart.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterEnd
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vginert.rohlik.cart.presentation.cart.models.CartModel
import com.vginert.rohlik.shared.presentation.compose.ProductImage
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
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing.M, vertical = Spacing.S)
    ) {
        Row {
            Text(
                modifier = Modifier.align(CenterVertically),
                text = "${cartItem.amount} x", style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.width(Spacing.M))
            ProductImage(
                modifier = Modifier
                    .size(80.dp)
                    .align(CenterVertically),
                imageUrl = cartItem.product.imageUrl
            )
            Spacer(modifier = Modifier.width(Spacing.S))
            Column(
                modifier = Modifier.align(CenterVertically)
            ) {
                Text(text = cartItem.product.name, style = MaterialTheme.typography.h6)
                Text(text = cartItem.product.price.toString(), style = MaterialTheme.typography.subtitle2)
            }
        }
        IconButton(
            modifier = Modifier.align(CenterEnd),
            onClick = { onRemoveClick(cartItem) }
        ) {
            Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
        }
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

