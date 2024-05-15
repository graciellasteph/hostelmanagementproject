package com.example.myproject.ui.theme.screens.Rooms


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.myproject.data.HostelViewModel
import com.example.myproject.data.ProductViewModel
import com.example.myproject.models.upload
import com.example.myproject.navigation.ROUTE_UPDATE_ROOM




@Composable
fun ViewUploadsScreen(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {

        var context = LocalContext.current
        var roomRepository = HostelViewModel(navController, context)


        val emptyUploadState = remember { mutableStateOf(upload("","","","","")) }
        var emptyUploadsListState = remember { mutableStateListOf<upload>() }

        var uploads = roomRepository.viewUploads(emptyUploadState, emptyUploadsListState)


        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "All uploads",
                fontSize = 30.sp,
                fontFamily = FontFamily.Cursive,
                color = Color.Red)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(){
                items(upload){
                    UploadItem(
                        name = it.name,
                        hostel = it.hostel,
                        fee= it.fee,
                        imageUrl = it.imageUrl,
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
fun UploadItem(name:String, fee:String, hostel:String, imageUrl:String, id:String,
               navController:NavHostController, roomRepository: HostelViewModel
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = name)
        Text(text = hostel)
        Text(text = fee )
        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(128.dp)
        )
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