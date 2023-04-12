package com.example.composerdemo1.ui.composables.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composerdemo1.ui.theme.orange
import com.example.composerdemo1.ui.theme.white

@Composable
fun StandardButton(
    text: String,
    onClicked: () -> Unit,
    enabled: Boolean = true,
    elevation: ButtonElevation? = null
) {
    Button(
        onClick = onClicked,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(backgroundColor = orange),
        elevation = elevation,
        shape = RoundedCornerShape(14.dp),
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth(),

    ) {
        Text(
            text = text,
            color = white,
            style = MaterialTheme.typography.button
        )
    }
}

@Preview
@Composable
fun PreviewStandardButton() {
    StandardButton(
        text = "Standard Button",
        onClicked = {}
    )
}