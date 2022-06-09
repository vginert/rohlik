package com.vginert.rohlik.catalog.presentation.categories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.vginert.rohlik.R
import com.vginert.rohlik.catalog.presentation.categories.CategoriesState.CategoriesError.UnknownError
import com.vginert.rohlik.catalog.presentation.categories.components.CategoryRow
import com.vginert.rohlik.catalog.presentation.categories.models.CategoryModel
import com.vginert.rohlik.shared.presentation.compose.ShowGenericError
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme
import java.util.*

@Composable
fun CategoriesScreen(
    uiState: CategoriesState = CategoriesState(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    onCategoryClick: (category: CategoryModel) -> Unit = {},
    onGenericErrorDismissed: () -> Unit = {},
    onGoToCartClick: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.categories_title)) },
                actions = {
                    IconButton(onClick = onGoToCartClick) {
                        Icon(
                            Icons.Filled.ShoppingCart,
                            contentDescription = stringResource(id = R.string.go_to_cart_button)
                        )
                    }
                }
            )
        },
        scaffoldState = scaffoldState,
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
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

            if (uiState.isLoadingContent) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

    if (uiState.error is UnknownError) {
        scaffoldState.ShowGenericError { onGenericErrorDismissed() }
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoriesScreenPreview() {
    val categories = listOf(
        CategoryModel(UUID.randomUUID().toString(), "Fruits", ""),
        CategoryModel(UUID.randomUUID().toString(), "Drinks", ""),
        CategoryModel(UUID.randomUUID().toString(), "Meal", ""),
        CategoryModel(UUID.randomUUID().toString(), "Fish", ""),
    )
    RohlikTheme {
        CategoriesScreen(
            uiState = CategoriesState(
                categories = categories,
                isLoadingContent = false
            )
        )
    }
}
