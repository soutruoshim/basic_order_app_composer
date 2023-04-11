package com.example.composerdemo1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    // Ui state

    var formUiState by mutableStateOf(FormUiState())

    //Ui event

    fun onFormEvent(formUiEvent: FormUiEvent){
        when(formUiEvent){
            is FormUiEvent.OnNameChange ->{
                formUiState = formUiState.copy(name = formUiEvent.name)
            }
            is FormUiEvent.OnPhoneChange ->{
                formUiState = formUiState.copy(phone = formUiEvent.phone)
            }
            is FormUiEvent.PayOrderClicked ->{
                println("Sending form with parameters: ${formUiState.name} and ${formUiState.phone}")
            }

        }
    }

    // Business's logic or maybe some UI's logic for update the state
    companion object {
        fun applyLogicToValidateInputs(name: String, phone: String): Boolean {
            return name.length > 1 && phone.length > 3
        }
    }

}