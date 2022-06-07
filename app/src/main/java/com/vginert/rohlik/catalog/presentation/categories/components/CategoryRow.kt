package com.vginert.rohlik.catalog.presentation.categories.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.vginert.rohlik.R
import com.vginert.rohlik.catalog.presentation.categories.models.CategoryModel
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import com.vginert.rohlik.shared.presentation.theme.Spacing
import java.util.*

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier,
    category: CategoryModel,
    onClick: (category: CategoryModel) -> Unit = {}
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                role = Role.Button,
                onClick = { onClick(category) }
            )
            .padding(horizontal = Spacing.M, vertical = Spacing.M)) {
        Row(
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            val fallbackImagePainter = painterResource(id = R.drawable.ic_category_placeholder)
            val iconPainter = rememberAsyncImagePainter(
                model = category.imageUrl,
                placeholder = fallbackImagePainter,
                error = fallbackImagePainter
            )
            val iconColor = if (iconPainter.state is AsyncImagePainter.State.Success) {
                Color.Unspecified
            } else {
                LocalContentColor.current.copy(alpha = LocalContentAlpha.current)
            }
            Icon(
                modifier = Modifier.align(CenterVertically),
                painter = iconPainter,
                tint = iconColor,
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(Spacing.M))
            Text(
                modifier = Modifier.align(CenterVertically),
                text = category.name,
                style = MaterialTheme.typography.h6
            )
        }
        Icon(
            modifier = Modifier.align(Alignment.CenterEnd),
            painter = painterResource(id = R.drawable.ic_arrow_forward),
            contentDescription = null
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryRowPreview() {
    val category = CategoryModel(
        id = UUID.randomUUID().toString(),
        name = "Fruits",
        imageUrl = "",
    )
    RohlikTheme {
        CategoryRow(category = category)
    }
}
