package com.vginert.rohlik.shared.presentation.compose

import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.stringResource
import com.vginert.rohlik.R

@Composable
fun ScaffoldState.ShowGenericError(
    message: String = stringResource(id = R.string.generic_error),
    duration: SnackbarDuration = SnackbarDuration.Short,
    onGenericErrorDismissed: () -> Unit = {}
) = LaunchedEffect(snackbarHostState) {
    snackbarHostState.showSnackbar(
        message = message,
        duration = duration,
    ).let {
        if (it == SnackbarResult.Dismissed) {
            onGenericErrorDismissed()
        }
    }
}
