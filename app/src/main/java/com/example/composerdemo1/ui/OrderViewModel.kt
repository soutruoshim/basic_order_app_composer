package com.example.composerdemo1.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class OrderViewModel: ViewModel() {

    // Ui state
    var name by mutableStateOf("")
    private set
    var phone by mutableStateOf("")
    private set


    //Ui event
    fun onNameChange():(String)->Unit = {
        name = it
    }

    fun onPhoneChange():(String)->Unit = {
        phone = it
    }

    fun payOrder():()->Unit = {
       println("Order by $name, and phone $phone")
    }

}