package com.example.composerdemo1.ui.utils

data class StateVsEvent(
    val value: String = "",
    val onValueChange: (String) -> Unit = {}
)