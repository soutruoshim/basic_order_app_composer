package com.example.composerdemo1.main

import android.content.res.Resources
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import com.example.composerdemo1.ui.patterns.OrderNowBottomBar
import com.example.composerdemo1.ui.patterns.OrderNowNavHost
import com.example.composerdemo1.ui.patterns.OrderNowTopBar
import com.example.composerdemo1.ui.theme.ComposerDemo1Theme
import com.example.composerdemo1.ui.theme.orange

@Composable
fun OrderNowScreen() {
    ComposerDemo1Theme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background,
            contentColor = orange
        ) {
            val appState = rememberAppState()
            Scaffold(
                scaffoldState = appState.scaffoldState,
                topBar = { OrderNowTopBar(appState) },
                bottomBar = { OrderNowBottomBar(navController = appState.navController) }
            ) { contentPadding ->
                OrderNowNavHost(appState, contentPadding)
            }
        }
    }
}

@Composable
@ReadOnlyComposable
fun resources(): Resources {
    LocalConfiguration.current
    return LocalContext.current.resources
}