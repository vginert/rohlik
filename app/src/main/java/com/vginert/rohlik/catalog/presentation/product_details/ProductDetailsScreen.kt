package com.vginert.rohlik.catalog.presentation.product_details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.R
import com.vginert.rohlik.shared.presentation.compose.ContentError
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun ProductDetailsScreen(
    uiState: ProductDetailsState = ProductDetailsState()
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        if (uiState.showContentNotFound) {
            ContentError(
                modifier = Modifier.align(Alignment.Center),
                title = { Text(text = stringResource(id = R.string.product_not_found)) }
            )
        }

        if (uiState.isLoadingContent) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductDetailsScreenPreview() {
    RohlikTheme {
        ProductDetailsScreen()
    }
}
