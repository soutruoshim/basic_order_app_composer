package com.example.composerdemo1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    // Ui state

    var formUiState by mutableStateOf(FormUiState())

    //Ui event
    fun onNameChange():(String)->Unit = {
       formUiState = formUiState.copy(name = it)
    }

    fun onPhoneChange():(String)->Unit = {
        formUiState = formUiState.copy(phone = it)
    }

    fun payOrder():()->Unit = {
       println("Order by ${formUiState.name}, and phone ${formUiState.phone}")
    }

}