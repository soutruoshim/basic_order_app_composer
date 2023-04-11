package com.example.composerdemo1

import android.os.Bundle
import android.text.Layout.Alignment
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OrderScreen()
        }
    }
}
// this is state full view(view contain or depend on a state are called stateful views)
@Composable
fun OrderScreen(){
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    ContactInformation(
        name=name,
        onNameChange={name = it},
        phone=phone,
        onPhoneChange={phone = it}
    )

}

// this is a stateless view(do not have a state dependency are known as stateless view)
@Composable
fun ContactInformation(
    name:String,
    onNameChange:(String)->Unit,
     phone:String,
    onPhoneChange:(String)->Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        TextField(label = { Text("User Name") }, value = name, onValueChange = onNameChange)
        Spacer(Modifier.padding(5.dp))
        TextField(label = { Text("Phone") }, value = phone, onValueChange = onPhoneChange)
        Spacer(Modifier.padding(5.dp))
        Button(onClick = {
            println("Order by $name and phone $phone")
        }) {
            Text("Pay now")
        }
    }
}

