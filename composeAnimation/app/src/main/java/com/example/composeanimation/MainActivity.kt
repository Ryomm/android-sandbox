package com.example.composeanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.animations.AnimateAsStateAnimation
import com.example.animations.AnimateContentSizeAnimation
import com.example.animations.AnimatedContentAnimation
import com.example.animations.AnimatedVisibilityAnimation
import com.example.animations.CrossfadeAnimation
import com.example.animations.RememberInfiniteTransitionAnimation
import com.example.animations.UpdateTransitionAnimation
import com.example.composeanimation.ui.theme.ComposeAnimationTheme

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
            var state6 by remember { mutableStateOf(true) }
            val size: Dp by animateDpAsState(targetValue = if(state6) 100.dp else 200.dp)

            ComposeAnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        FloatingActionButton(onClick = {visible1 = !visible1}, modifier = Modifier.padding(4.dp)) {
                            AnimatedVisibilityAnimation(visible = visible1)
                        }

                        FloatingActionButton(onClick = { state1 = !state1 }) {
                            AnimateContentSizeAnimation(state = state1)
                        }

                        FloatingActionButton(onClick = { state2 = !state2 }) {
                            CrossfadeAnimation(state = state2)
                        }

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

                        RememberInfiniteTransitionAnimation(state = state4)

                        FloatingActionButton(onClick = { state5 = !state5 }) {
                            UpdateTransitionAnimation(transition = transition)
                        }

                        FloatingActionButton(onClick = { state6 = !state6 }) {
                            AnimateAsStateAnimation(size = size)
                        }
                    }
                }
            }
        }
    }
}