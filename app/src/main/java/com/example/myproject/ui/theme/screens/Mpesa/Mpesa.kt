package com.example.myproject.ui.theme.screens.Mpesa

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myproject.navigation.ROUTE_HOME

@Composable
fun MpesaScreen(navController : NavHostController){
    val context = LocalContext.current

    Spacer(
        modifier = Modifier
            .height(20.dp))
    OutlinedButton(
        onClick = {
            navController.navigate(ROUTE_HOME)
        val simToolkitLaunchIntent =
            context.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolkitLaunchIntent?.let { context.startActivity(it) }
        },
        colors = ButtonDefaults.buttonColors(Color.Blue),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Xpress Mpesa",
            fontSize = 20.sp)

    }
}
@Preview
@Composable
private fun MpesaPrev(){
    MpesaScreen(rememberNavController)
}