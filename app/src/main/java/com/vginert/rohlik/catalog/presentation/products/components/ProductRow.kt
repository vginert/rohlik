package com.vginert.rohlik.catalog.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.catalog.presentation.products.models.ProductModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing
import java.util.*

@Composable
fun ProductRow(
    modifier: Modifier = Modifier,
    product: ProductModel,
    onClick: (productId: String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = { onClick(product.id) }
            )
            .padding(horizontal = Spacing.M, vertical = Spacing.S)
    ) {
        Text(text = product.name)
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductRowPreview() {
    val product = ProductModel(
        id = UUID.randomUUID().toString(),
        name = "Cola"
    )
    RohlikTheme {
        ProductRow(product = product)
    }
}
