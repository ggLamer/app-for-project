package com.gglamer.jetpackcompose

sealed class Screen(val route: String){
    object MainScreen: Screen("main_screen")


    //SmartCity
    object SmartCity_Screen: Screen("smartcity_screen")
    object SmartHome_Screen: Screen("smarthome_screen")
    object GasStation_Screen: Screen("gasstation_screen")
    object WaterStation_Screen: Screen("waterstation_screen")

    //GreenHouse
    object GreenHouse_Screen: Screen("greenhouse_screen")
}

