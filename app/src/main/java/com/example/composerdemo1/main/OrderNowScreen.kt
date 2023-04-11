package com.example.composerdemo1.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composerdemo1.ui.patterns.OrderNowBottomBar
import com.example.composerdemo1.ui.patterns.OrderNowTopBar
import com.example.composerdemo1.ui.theme.ComposerDemo1Theme

@Composable
fun OrderNowScreen() {
    ComposerDemo1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Scaffold(
                topBar = { OrderNowTopBar() },
                bottomBar = { OrderNowBottomBar() }
            ) { innerPaddingModifier ->
                println(innerPaddingModifier)
            }
        }
    }
}