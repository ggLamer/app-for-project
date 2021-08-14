package com.gglamer.jetpackcompose

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class smartHome {

    @Composable
    fun smartHome() {
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
            devices()
            mainParameter()
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
                smarthome("FAN", Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF3FFF7C),
                        Color(0xFF3FFBE0),
                        ))
                )

                waterstation("WATER",Color(0xFF3CCBFF))

                light("LIGHT")
            }
            Spacer(modifier = Modifier.padding(10.dp))
        }
    }
    @Composable
    fun smarthome(name: String, brush: Brush) {
        val infiniteTransition = rememberInfiniteTransition()
        var state by remember { mutableStateOf(1)}


        Box(
            modifier = Modifier
                //.padding(10.dp)
                .width(120.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    state += 1
                }
                .background(brush = brush),
            Alignment.BottomStart,
            ){
            Text(
                text = name,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            when(state){
                0->{
                    val rotate by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = Float.MAX_VALUE,
                    animationSpec = infiniteRepeatable(
                        tween(),

                    )
                )
                    Image(
                        painter = painterResource(id = R.drawable.fan),
                        alignment = Alignment.Center,
                        contentDescription = "fan",
                        modifier = Modifier.rotate(rotate),
                        contentScale = ContentScale.Crop
                    )
                }
                1-> println("on")
                else -> state = 0
            }
        }
    }
    @Composable
    fun waterstation(name: String, color: Color) {
        val infiniteTransition = rememberInfiniteTransition()
        var brush by remember { mutableStateOf(color)}
        var state by remember { mutableStateOf(1)}


        Box(
            modifier = Modifier
                //.padding(10.dp)
                .width(120.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    state += 1
                }
                .background(brush),
            Alignment.BottomStart,
            ){
            Text(
                text = name,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            when(state){
                0->{
                    val gradient by infiniteTransition.animateColor(
                        initialValue = Color(0xFF2f80ff),
                        targetValue = Color(0xFF3CCBFF),
                        animationSpec = infiniteRepeatable(
                            tween(1000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                    brush = gradient
                }
                1->{ }
                else -> state = 0
            }
        }
    }

    @Composable
    fun light(name: String) {
        val infiniteTransition = rememberInfiniteTransition()
        var state by remember { mutableStateOf(1)}
        var lightcolor by remember { mutableStateOf(Color.Gray)}

        Box(
            modifier = Modifier
                //.padding(10.dp)
                .width(120.dp)
                .height(120.dp)
                .clip(RoundedCornerShape(10))
                .clickable {
                    state += 1
                }
                .background(lightcolor),
            Alignment.BottomStart,
            ){
            Text(
                text = name,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.padding(10.dp)
            )
            Color(0xFFa1ffd9)
            when(state){
                0->{
                    val light by infiniteTransition.animateColor(
                        initialValue = Color(0xFFFFF550),
                        targetValue = Color(0xFFf3ff77),
                        animationSpec = infiniteRepeatable(
                            tween(1000),
                            repeatMode = RepeatMode.Reverse
                        )
                    )
                    lightcolor = light
                }
                1->{ lightcolor = Color.Gray }
                else -> state = 0
            }
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