package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(name: String, age: Int, navigationToThirdScreen: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("This is the Second Screen", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Text("Hello $age years old $name!", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigationToThirdScreen()
        }) {
            Text("Go to Third Screen")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun SecondPreview(){
    SecondScreen("Laura", 43) {}
}