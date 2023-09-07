package com.example.composeanimation

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animations.AnimateAsStateAnimation
import com.example.animations.AnimateContentSizeAnimation
import com.example.animations.AnimatedContentAnimation
import com.example.animations.AnimatedVisibilityAnimation
import com.example.animations.AnimationAPIAnimation
import com.example.animations.CrossfadeAnimation
import com.example.animations.RememberInfiniteTransitionAnimation
import com.example.animations.Sample
import com.example.animations.Sample2
import com.example.animations.Sample3
import com.example.animations.Sample4
import com.example.animations.UpdateTransitionAnimation
import com.example.composeanimation.ui.theme.ComposeAnimationTheme
import java.util.Timer
import kotlin.concurrent.schedule

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // AnimatedVisibility用
            var visible1 by remember {
                mutableStateOf(true)
            }

            // AnimateContentSize用
            var state1 by remember {
                mutableStateOf(true)
            }

            // Crossfade用
            var state2 by remember {
                mutableStateOf(true)
            }

            // AnimatedContent用
            var state3 by remember {
                mutableStateOf(0)
            }

            // rememberInfiniteTransition用
            val infiniteTransition = rememberInfiniteTransition()
            val state4 by infiniteTransition.animateFloat(
                initialValue = 0F,
                targetValue = 360F,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000, easing = LinearEasing),
                    repeatMode = RepeatMode.Reverse
                )
            )

            // updateTransition用
            var state5 by remember { mutableStateOf(true) }
            val transition = updateTransition(state5)

            // animateAsState用
            var state6 by remember { mutableStateOf(100) }
            val size: Dp by animateDpAsState(targetValue = if(state6<400) 1.dp*(state6) else 100.dp)

            // sample用
            var visible by remember {
                mutableStateOf(true)
            }

            // sample2用
            var state7 by remember { mutableStateOf(0f) }
            val progress = updateTransition(targetState = state7)

            // sample3用
            var checkbox1 by remember { mutableStateOf(false) }
            var checkbox2 by remember { mutableStateOf(false) }
            var checkbox3 by remember { mutableStateOf(false) }
            var checkedNum by remember { mutableStateOf(0) }
            val state8 = updateTransition(targetState = checkedNum.toFloat() / 3)

            // sample4.5用
            var state9 by remember { mutableStateOf(30) }
            val position: Dp by animateDpAsState(targetValue = state9.dp)

            // sample4用
            var state10 by remember {
                mutableStateOf(100)
            }
            val size2: Dp by animateDpAsState(targetValue = state10.dp)


            ComposeAnimationTheme {
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        FloatingActionButton(onClick = {visible1 = !visible1}, modifier = Modifier.padding(4.dp)) {
                            AnimatedVisibilityAnimation(visible = visible1)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        FloatingActionButton(onClick = { state1 = !state1 }) {
                            AnimateContentSizeAnimation(state = state1)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        FloatingActionButton(onClick = { state2 = !state2 }) {
                            CrossfadeAnimation(state = state2)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Spacer(modifier = Modifier.padding(4.dp))
                            AnimatedContentAnimation(state = state3)
                            Spacer(modifier = Modifier.padding(4.dp))
                            Button(onClick = { state3 += 1}) {
                                Text(text = "+")
                            }
                            Button(onClick = {
                                if (state3 > 0) {
                                    state3 -= 1
                                }
                            }) {
                                Text(text = "-")
                            }
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        RememberInfiniteTransitionAnimation(state = state4)

                        Spacer(modifier = Modifier.padding(4.dp))

                        FloatingActionButton(onClick = { state5 = !state5 }) {
                            UpdateTransitionAnimation(transition = transition)
                        }

                        FloatingActionButton(onClick = { if(state6<400) state6 = state6+10 else state6=100 }) {
                            AnimateAsStateAnimation(size = size)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row {
                            Spacer(modifier = Modifier.padding(4.dp))
                            Button(
                                onClick = {visible = !visible}
                            ) {
                                if(visible) Text(text = "TurnOff") else Text(text = "TurnOn")
                            }
                            Sample(visible = visible)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row {
                            Spacer(modifier = Modifier.padding(4.dp))
                            Button(
                                onClick = {if(state7<=1.0f) state7 += 0.1f }
                            ) {
                                Text(text = "+")
                            }
                            Sample2(state = progress)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Row {
                            Column {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = checkbox1,
                                        onCheckedChange = {
                                            checkbox1 = !checkbox1
                                            if (checkbox1) checkedNum += 1 else checkedNum -= 1
                                        }
                                    )
                                    Text(text = "ほにゃーん1")
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = checkbox2,
                                        onCheckedChange = {
                                            checkbox2 = !checkbox2
                                            if (checkbox2) checkedNum += 1 else checkedNum -= 1
                                        }
                                    )
                                    Text(text = "ほにゃーん2")
                                }
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = checkbox3,
                                        onCheckedChange = {
                                            checkbox3 = !checkbox3
                                            if (checkbox3) checkedNum += 1 else checkedNum -= 1
                                        }
                                    )
                                    Text(text = "ほにゃーん3")
                                }
                            }
                            Spacer(modifier = Modifier.padding(4.dp))
                            Sample3(state = state8)
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        Button(
                            onClick = {if(state9<250) state9+=250 else state9-=250},
                            modifier = Modifier
                                .offset(x = position, y = 10.dp)
                                .size(100.dp),
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                            border = BorderStroke(1.dp, Color.LightGray),
                            contentPadding = PaddingValues(0.dp)
                        ){
                            Text(text = "・x・")
                        }

                        Spacer(modifier = Modifier.padding(4.dp))

                        FloatingActionButton(onClick = {state10+=10}, modifier = Modifier.padding(4.dp)) {
                            Sample4(state = state10)
                        }
                    }
                }
            }
        }
    }
}