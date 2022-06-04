package com.vginert.rohlik.main.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vginert.rohlik.shared.presentation.theme.RohlikTheme

@Composable
fun MainScreen(
    navController: NavHostController = rememberNavController(),
) {
    MainNavGraph(navController = navController)
}

@Preview
@Composable
private fun MainScreenPreview() {
    RohlikTheme {
        MainScreen()
    }
}
