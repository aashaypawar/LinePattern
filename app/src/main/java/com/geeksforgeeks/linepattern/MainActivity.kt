package com.geeksforgeeks.linepattern

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            // Creating a Simple Scaffold Layout for the application
            Scaffold(

                // Creating a Top Bar
                topBar = { TopAppBar(title = { Text("GFG | Line Pattern", color = Color.White) }, backgroundColor = Color(0xff0f9d58)) },

                // Creating Content
                content = {

                    // Creating a Column Layout
                    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {

                        Canvas(
                            Modifier
                                .padding(10.dp)
                                .height(30.dp)
                                .fillMaxWidth()
                                .clip(CircleShape)
                        ) {
                            val step = 10.dp
                            val angleDegrees = 45f
                            val stepPx = step.toPx()
                            val stepsCount = (size.width / stepPx).roundToInt()
                            val actualStep = size.width / stepsCount
                            val dotSize = Size(width = actualStep / 2, height = size.height * 2)
                            for (i in -1..stepsCount) {
                                val rect = Rect(
                                    offset = Offset(x = i * actualStep, y = (size.height - dotSize.height) / 2),
                                    size = dotSize,
                                )
                                rotate(angleDegrees, pivot = rect.center) {
                                    drawRect(
                                        Color.Blue,
                                        topLeft = rect.topLeft,
                                        size = rect.size,
                                    )
                                }
                            }
                        }

                    }
                }
            )
        }
    }
}
