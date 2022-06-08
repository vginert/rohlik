package com.vginert.rohlik.catalog.presentation.products.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vginert.rohlik.R
import com.vginert.rohlik.shared.presentation.compose.ProductImage
import com.vginert.rohlik.shared.presentation.models.PriceModel
import com.vginert.rohlik.shared.presentation.models.ProductModel
import com.vginert.rohlik.shared.presentation.theme.Elevation
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing
import java.util.*

@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductModel,
    onClick: (product: ProductModel) -> Unit = {},
    onAddToCartClick: (product: ProductModel) -> Unit = {}
) {
    Card(
        elevation = Elevation.S
    ) {
        Column(
            modifier = modifier
                .clickable(
                    role = Role.Button,
                    onClick = { onClick(product) }
                )
                .padding(Spacing.M)
        ) {
            ProductImage(
                modifier = modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                imageUrl = product.imageUrl
            )
            Spacer(modifier = Modifier.height(Spacing.M))
            Text(
                text = product.name,
                style = MaterialTheme.typography.h5
            )
            Spacer(modifier = Modifier.height(Spacing.XS))
            Text(text = product.price.toString())
            Spacer(modifier = Modifier.height(Spacing.S))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onAddToCartClick(product) }
            ) {
                Text(text = stringResource(id = R.string.add_to_cart_button))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductItemPreview() {
    val product = ProductModel(
        id = UUID.randomUUID().toString(),
        name = "Cola",
        price = PriceModel(12.5, Currency.getInstance("EUR")),
        imageUrl = "",
    )
    RohlikTheme {
        Box(
            modifier = Modifier
                .width(200.dp)
                .padding(Spacing.M)
        ) {
            ProductItem(product = product)
        }
    }
}
