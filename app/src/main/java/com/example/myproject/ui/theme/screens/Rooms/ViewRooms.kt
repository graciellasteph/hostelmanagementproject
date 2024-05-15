package com.example.myproject.ui.theme.screens.Rooms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
//import androidx.navigation.NavHostController
import com.example.myproject.data.HostelViewModel
//import com.example.myproject.data.ProductViewModel
import com.example.myproject.models.Rooms
import com.example.myproject.navigation.ROUTE_UPDATE_ROOM





@Composable
fun ViewRoomsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        val context = LocalContext.current
        val roomRepository = HostelViewModel(navController, context)
        val emptyRoomState = remember { mutableStateOf(Rooms("","","","")) }
        val emptyRoomsListState = remember { mutableStateListOf<Rooms>() }

        val rooms = roomRepository.viewRooms(emptyRoomState, emptyRoomsListState)


        Column(
            modifier = Modifier
                .fillMaxSize().background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "All rooms",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(Room){
                    RoomItem(
                        name = it.name,
                        hostel = it.hostel,
                        fee = it.fee,
                        id = it.id,
                        navController = navController,
                        roomRepository = roomRepository
                    )
                }
            }
        }
    }

}



@Composable
fun RoomItem(name:String, hostel:String, fee:String, id:String,
                navController:NavHostController, roomRepository: HostelViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = hostel)
        Text(text = fee)
        Button(onClick = {
            roomRepository.deleteHostel(id)
        }) {
            Text(text = "Delete")
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_ROOM+"/$id")
        }) {
            Text(text = "Update")
        }
    }

}

@Preview
@Composable
fun view() {
    ViewRoomsScreen(rememberNavController())

}