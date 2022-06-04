package com.vginert.rohlik.catalog.presentation.categories.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.catalog.presentation.categories.models.CategoryModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing
import java.util.*

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    category: CategoryModel,
    onClick: (categoryId: String) -> Unit = {}
) {
    Row(
        modifier = modifier
            .clickable(
                role = Role.Button,
                onClick = { onClick(category.id) }
            )
            .padding(horizontal = Spacing.M, vertical = Spacing.S)
    ) {
        Text(text = category.name)
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryRowPreview() {
    val category = CategoryModel(
        id = UUID.randomUUID().toString(),
        name = "Fruits"
    )
    RohlikTheme {
        CategoryRow(category = category)
    }
}
