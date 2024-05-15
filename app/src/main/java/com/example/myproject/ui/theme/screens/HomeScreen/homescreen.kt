package com.example.myproject.ui.theme.screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject.navigation.ROUTE_ROOMSIZE
import com.example.myproject.navigation.ROUTE_VIEW_ROOM

//import androidx.navigation.NavController
//import androidx.navigation.compose.rememberNavController
//import com.example.myproject.navigation.ROUTE_ROOMSIZE
//import com.example.myproject.navigation.ROUTE_VIEW_ROOMS
//import com.mwendwa.homescreens.navigation.ROUTE_ADD_PRODUCT
//import com.mwendwa.homescreens.navigation.ROUTE_VIEW_PRODUCT

@Composable
fun HomeScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context= LocalContext.current
        // var productdata=productviewmodel(navController,context)

        Text(text = "Welcome to Home page",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))

        Text(text = "Select a room you like",
            color = Color.Cyan,
            fontFamily = FontFamily.Cursive,
            fontSize = 30.sp)
        Spacer(modifier = Modifier.height(100.dp))


        Button(onClick = {
            navController.navigate(ROUTE_ROOMSIZE)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "key in the number of rooms you would wish to have ")
        }
        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            navController.navigate(ROUTE_VIEW_ROOM)
        },modifier = Modifier.fillMaxWidth()) {
            Text(text = "View rooms")
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreen(rememberNavController())
}