package com.example.composerdemo1.ui.features.cart.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composerdemo1.ui.composables.buttons.StandardButton
import com.example.composerdemo1.R.string as AppText

@Composable
fun CartBottom(
    checkoutSelected: () -> Unit,
    checkoutReady: Boolean
) {
    StandardButton(
        text = stringResource(id = AppText.checkout),
        onClicked = checkoutSelected,
        enabled = checkoutReady
    )
}

@Preview
@Composable
fun PreviewCartBottom() {
    CartBottom(
        checkoutSelected = {},
        checkoutReady = true
    )
}