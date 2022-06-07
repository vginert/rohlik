package com.vginert.rohlik.catalog.presentation.categories

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun CategoriesRoute(
    navigator: CategoriesNavigator,
    viewModel: CategoriesViewModel = getViewModel(),
    scaffoldState: ScaffoldState = rememberScaffoldState(),
) {
    val uiState by viewModel.uiState.collectAsState()

    CategoriesScreen(
        uiState = uiState,
        scaffoldState = scaffoldState,
        onCategoryClick = navigator::goToProductsScreen,
        onGenericErrorDismissed = viewModel::onGenericErrorDismissed,
    )
}
