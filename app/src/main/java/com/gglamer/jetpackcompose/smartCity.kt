package com.gglamer.jetpackcompose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.expandIn
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

class smartCity(val navController: NavController) {
    @Composable
    fun SmartCity() {
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
            mainParameter()
            devices()
        }
    }
    @Composable
    fun devices(){
        Column(
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(10.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()

            ){
                projects("SmartHome", Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3FFF7C),
                        Color(0xFF3FFBE0),
                    )),
                    Screen.SmartHome_Screen.route
                )
                projects("Water Station", Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2f80ff),
                        Color(0xFF3CCBFF),
                    )),
                    route = Screen.WaterStation_Screen.route
                )
                projects("Gas Station", Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFa1ffd9),
                        Color(0xFFf3ff77),
                    )),
                    route = Screen.GasStation_Screen.route
                )
            }
            Spacer(modifier = Modifier.padding(10.dp))

        }
    }
    @Composable
    fun projects(name: String, brush: Brush, route: String) {
        Box(
            modifier = Modifier
                //.padding(10.dp)
                .width(120.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(10))
                .clickable { navController.navigate(route = route) }
                .background(brush = brush),
            Alignment.BottomStart,
        ){
            Text(
                text = name,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
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

}