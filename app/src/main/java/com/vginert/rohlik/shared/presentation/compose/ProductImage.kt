package com.vginert.rohlik.shared.presentation.compose

import androidx.compose.foundation.Image
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.vginert.rohlik.R
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun ProductImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    contentDescription: String? = null
) {
    val imagePlaceholder = painterResource(id = R.drawable.ic_product_placeholder)
    val imagePainter = rememberAsyncImagePainter(
        model = imageUrl,
        placeholder = imagePlaceholder,
        error = imagePlaceholder
    )
    val imageColorFilter = if (imagePainter.state !is AsyncImagePainter.State.Success) {
        ColorFilter.tint(LocalContentColor.current.copy(alpha = LocalContentAlpha.current))
    } else {
        null
    }
    Image(
        modifier = modifier,
        painter = imagePainter,
        colorFilter = imageColorFilter,
        contentDescription = contentDescription
    )
}

@Preview(showBackground = true)
@Composable
private fun ProductImagePreview() {
    RohlikTheme {
        ProductImage(imageUrl = "")
    }
}
