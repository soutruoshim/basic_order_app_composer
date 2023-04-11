package com.example.composerdemo1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
@Composable
fun OrderScreen(viewModel: OrderViewModel = viewModel()){

    ContactInformation(
        name=viewModel.formUiState.name,
        onNameChange=viewModel.onNameChange(),
        phone=viewModel.formUiState.phone,
        onPhoneChange=viewModel.onPhoneChange(),
        payOrder = viewModel.payOrder(),
        isValidPayOrder = viewModel.formUiState.successValidated
    )
}

// this is a stateless view(do not have a state dependency are known as stateless view)
@Composable
fun ContactInformation(
    name:String,
    onNameChange:(String)->Unit,
    phone:String,
    onPhoneChange:(String)->Unit,
    payOrder: () -> Unit,
    isValidPayOrder:Boolean
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(label = { Text("User Name") }, value = name, onValueChange = onNameChange)
        Spacer(Modifier.padding(5.dp))
        TextField(label = { Text("Phone") }, value = phone, onValueChange = onPhoneChange)
        Spacer(Modifier.padding(5.dp))
        Button(onClick = payOrder,  enabled = isValidPayOrder) {
            Text("Pay now")
        }
    }
}