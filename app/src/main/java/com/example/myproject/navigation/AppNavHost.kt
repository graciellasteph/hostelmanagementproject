package com.example.myproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import com.example.myproject.ui.theme.screens.HomeScreen.HomeScreen
import com.example.myproject.ui.theme.screens.LoginScreen.LoginScreen
import com.example.myproject.ui.theme.screens.RegisterScreen.RegisterScreen
import com.example.myproject.ui.theme.screens.Rooms.AddProductsScreen
//import com.example.myproject.ui.theme.screens.Rooms.UpdateProductsScreen
//import com.example.myproject.ui.theme.screens.Rooms.ViewProductsScreen
import com.example.myproject.ui.theme.screens.gallery.galleryScreen

@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination:String = ROUTE_REGISTER){
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination ){
        composable
        (ROUTE_HOME){ HomeScreen(navController)
        }
        composable
        (ROUTE_REGISTER){ RegisterScreen(navController)
        }
        composable
        (ROUTE_LOGIN){ LoginScreen(navController)
        }
       composable
        (ROUTE_GALLERY){ galleryScreen(navController)
        }
//        composable(ROUTE_PROFILE){ ProfileScreen(navController)}
        composable
        (ROUTE_ADD_ROOM){ AddProductsScreen(navController)
        }
        composable
        (ROUTE_VIEW_ROOM) { ViewProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_ROOM+"/{id}") { passedData ->
            UpdateProductsScreen(
                navController, passedData.arguments?.getString("id")!!
            )
        }
        composable(ROUTE_VIEW_UPLOAD){
            //           viewUploadsScreen(navController)
        }

    }

}