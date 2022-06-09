package com.vginert.rohlik.shared.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.vginert.rohlik.shared.presentation.theme.Spacing

@Composable
fun ContentError(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null
) {
    Column(modifier = modifier) {
        Icon(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(60.dp),
            imageVector = Icons.Filled.Warning,
            contentDescription = null
        )
        if(title != null) {
            Spacer(modifier = Modifier.height(Spacing.L))
            title()
        }
    }
}
