package com.example.encryptionapp.navigations

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.encryptionapp.screens.AboutScreen
import com.example.encryptionapp.screens.DecryptionScreen
import com.example.encryptionapp.screens.EncryptionScreen


sealed class Screens(val route : String){
    data object EncryptionScreen : Screens("EncryptionScreen")
    data object DecryptionScreen : Screens("DecryptionScreen")
    data object AboutScreen : Screens("AboutScreen")
}


@Composable
fun Nav(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screens.EncryptionScreen.route){
        composable(Screens.EncryptionScreen.route){
            EncryptionScreen()
        }
        composable(Screens.DecryptionScreen.route){
            DecryptionScreen()
        }
        composable(Screens.AboutScreen.route){
            AboutScreen()
        }
    }
}