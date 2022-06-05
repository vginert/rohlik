package com.vginert.rohlik.catalog.presentation.categories

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.catalog.presentation.categories.components.CategoryRow
import com.vginert.rohlik.catalog.presentation.categories.models.CategoryModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import java.util.*

@Composable
fun CategoriesScreen(
    uiState: CategoriesState = CategoriesState(),
    onCategoryClick: (id: String) -> Unit = {}
) {
    LazyColumn {
        uiState.categories.forEach { category ->
            item(key = category.id) {
                CategoryRow(
                    modifier = Modifier.fillMaxWidth(),
                    category = category,
                    onClick = onCategoryClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoriesScreenPreview() {
    val categories = listOf(
        CategoryModel(UUID.randomUUID().toString(), "Fruits"),
        CategoryModel(UUID.randomUUID().toString(), "Drinks"),
        CategoryModel(UUID.randomUUID().toString(), "Meal"),
        CategoryModel(UUID.randomUUID().toString(), "Fish"),
    )
    RohlikTheme {
        CategoriesScreen(
            uiState = CategoriesState(
                categories = categories
            )
        )
    }
}
