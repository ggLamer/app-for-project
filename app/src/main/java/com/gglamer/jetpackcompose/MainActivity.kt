package com.gglamer.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.navigation.compose.*


var temp = mutableStateOf("none")
var humi = mutableStateOf("none")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        CoroutineScope(Dispatchers.IO).launch {
            while (true) {
                parametrs().send("t")
                parametrs().send("t")
                parametrs().send("t")
                parametrs().gettemp()

                parametrs().send("h")
                parametrs().send("h")
                parametrs().send("h")
                parametrs().gethumidity()

                delay(1000)
            }
        }
        setContent {
            Navgation()
        }
    }
}
