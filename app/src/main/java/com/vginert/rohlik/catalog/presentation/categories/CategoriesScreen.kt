package com.vginert.rohlik.catalog.presentation.categories

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun CategoriesScreen(
    uiSate: CategoriesState = CategoriesState
) {
}

@Preview(showBackground = true)
@Composable
private fun CategoriesScreenPreview() {
    RohlikTheme {
        CategoriesScreen()
    }
}
