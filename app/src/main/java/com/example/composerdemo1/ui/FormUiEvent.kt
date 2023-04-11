package com.example.composerdemo1.ui

sealed class FormUiEvent {
    data class OnNameChange(val name: String): FormUiEvent()
    data class OnPhoneChange(val phone: String): FormUiEvent()
    object PayOrderClicked: FormUiEvent()
}