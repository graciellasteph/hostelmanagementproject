package com.example.myproject.ui.theme.screens.Rooms

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject.data.HostelViewModel

import com.example.myproject.models.Rooms
import com.example.myproject.navigation.ROUTE_VIEW_ROOM


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateRoomScreen(navController: NavHostController, id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var size by remember { mutableStateOf("") }
        var fee by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Rooms/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var room = snapshot.getValue(Rooms::class.java)
                name = room!!.name
                size = room!!.hostel
                fee = room!!.fee
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Text(
            text = "Add room",
            fontSize = 30.sp,
            fontFamily = FontFamily.Cursive,
            color = Color.Red,
            modifier = Modifier.padding(20.dp),
            fontWeight = FontWeight.Bold,
            textDecoration = TextDecoration.Underline
        )

        var roomName by remember { mutableStateOf(TextFieldValue(name)) }
        var roomSize by remember { mutableStateOf(TextFieldValue(size)) }
        var roomFee by remember { mutableStateOf(TextFieldValue(fee)) }

        OutlinedTextField(
            value = roomName,
            onValueChange = { roomName = it },
            label = { Text(text = "Room name *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = roomSize,
            onValueChange = { roomSize = it },
            label = { Text(text = "Room size *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = roomFee,
            onValueChange = { roomFee = it },
            label = { Text(text = "Room fee *") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var roomRepository = HostelViewModel(navController, context)
            roomRepository.updateHostel(roomName.text.trim(),roomSize.text.trim(),
                roomFee.text.trim(),id)
            navController.navigate(ROUTE_VIEW_ROOM)

        }) {
            Text(text = "Update")
        }

    }
}

@Preview
@Composable
fun update() {
    UpdateRoomScreen(rememberNavController(), id = "")
}