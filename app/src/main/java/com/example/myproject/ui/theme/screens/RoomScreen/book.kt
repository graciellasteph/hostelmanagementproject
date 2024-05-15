package com.example.myproject.ui.theme.screens.RoomScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myproject.navigation.ROUTE_MPESA

@Composable
fun BookingScreen(navController : NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var context = LocalContext.current
        var book by remember { mutableStateOf(TextFieldValue(""))}

        OutlinedTextField(
            value = book, onValueChange = { book = it },
            label = {
                Text(
                    text = "Please book a room of comfort" )},
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Button(
            onClick = { navController.navigate(ROUTE_MPESA)
            }, modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Book")

        }

    }

}


@Preview
@Composable
fun HostelScreenPreview(){
    BookingScreen ()

}