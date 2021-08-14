package com.gglamer.jetpackcompose

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.MainScope


@Composable
fun Navgation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Screen.MainScreen.route) {

        composable(route = Screen.MainScreen.route) { mainmenu(navController = navController).mainmenu() }

        //SmartCity
        composable(route = Screen.SmartCity_Screen.route) { smartCity(navController = navController).SmartCity() }
        composable(route = Screen.SmartHome_Screen.route) { smartHome().smartHome() }
        composable(route = Screen.WaterStation_Screen.route) {}
        composable(route = Screen.GasStation_Screen.route) {}

        //GreenHouse
        composable(route = Screen.GreenHouse_Screen.route) {}
    }
}
