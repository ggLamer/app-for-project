package com.gglamer.jetpackcompose

import android.content.res.Resources
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.net.ServerSocket
import java.net.Socket
import java.util.*


class mainmenu(val navController: NavController) {


    @Composable
    fun mainmenu(){
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFFffc153),
                            Color(0xFF47b39d),
                            Color(0xFFb05f6d),
                            //Color(0xFFEB6B56),
                            Color(0xFF462446),


                            )
                    )
                )
        ) {
            hello()
            mainParameter()
            projects()
        }
    }

    @Composable
    fun projects(){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp)

        ) {

            Row() {
                myproject(
                    name = "SmartCity",
                    drawable = R.drawable.index,
                    route = Screen.SmartCity_Screen.route
                )
                Spacer(modifier = Modifier.padding(10.dp))
                myproject(name = "GreenHouse", drawable = R.drawable.index, route = Screen.GreenHouse_Screen.route)
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }

    @Composable
    fun hello() {
        Text(
            text = "Приветствую вас Азамат" ,
            color = Color.White,
            modifier = Modifier
                .padding(30.dp)
                .clickable {
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
                },
            fontSize = 20.sp
            )
    }
    @Composable
    fun mainParameter(){
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .height(150.dp)
                .clip(RoundedCornerShape(10))
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF451E61),
                            Color(0xFFFB8E6A)
                        )
                    )
                )

        ){
            Temp()
        }
    }
    @Composable
    fun Temp(){
        Box(
            modifier = Modifier
                .padding(10.dp)
                .width(130.dp)
                .height(130.dp)
                .clip(RoundedCornerShape(10))
                .background(Color.White)
        ){
            Box(modifier = Modifier

                .width(105.dp)
                .height(105.dp)
                .clip(RoundedCornerShape(10))
                .background(Color(0xFF716F81))
                .align(Alignment.Center),
                Alignment.Center,

            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Text(
                        text = "${temp.value}°C",
                        fontSize = 20.sp
                    )
                    Text(
                        text = "${humi.value}%",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }

    @Composable
    fun myproject(name: String, drawable: Int, route: String) {
        Box(
            modifier = Modifier
                //.padding(10.dp)
                .width(180.dp)
                .height(180.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    navController.navigate(route = route)
                }
                .background(Color.White),
            Alignment.BottomStart,

        ){
            androidx.compose.foundation.Image(
                painter = painterResource(drawable),
                contentDescription = "",
                contentScale = ContentScale.Crop ,
                modifier = Modifier
                    .fillMaxSize()
            )
            Text(
                text = name,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)

            )

        }

    }



}



