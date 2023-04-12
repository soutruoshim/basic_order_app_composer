package com.example.composerdemo1.ui.features.checkout.states


data class ContactFormState(
    val username: String = "",
    val phone: String = "",
    val address: String = "",
)

val ContactFormState.successValidated: Boolean
    get() = username.length > 1
            && phone.length > 1
            && address.length > 1