package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(navigationToSecondScreen: (String, Int) -> Unit){
    val name = remember{
        mutableStateOf("")
    }
    val age = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("This is the First Screen",fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = name.value,
            onValueChange ={
            name.value = it},
            label = { Text(text = "Enter your name")})

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = age.value,
            onValueChange ={
            age.value = it.filter{it.isDigit()}},
            label = { Text(text = "Enter your age")})

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val ageInt = age.value.toIntOrNull() ?: 0
            navigationToSecondScreen(name.value, ageInt)
        }){
            Text("Go to Second Screen")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun FirstPreview(){
    FirstScreen({ _, _ -> })
}