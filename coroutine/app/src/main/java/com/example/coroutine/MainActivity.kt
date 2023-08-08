package com.example.coroutine

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coroutine.ui.theme.CoroutineTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope
import java.lang.Exception

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoroutineTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

class GreetingViewModel() {
    suspend fun lazy(value: Int, timeMillis: Long): Int {
        delay(timeMillis)
        Log.i("launch", "value: ${value}, timeMillis: ${timeMillis}")
        return value
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val scope = CoroutineScope(Dispatchers.Default)

    scope.launch {
        try {
            throw Exception()
        }catch (e: Exception) {
            Log.i("launch", "エラーが起きたよ")
            scope.cancel()
        }

        launch {
            Log.i("launch", "子にキャンセルが伝播してくるよ")
        }

        launch(Job()) {
            Log.i("launch", "親と独立したライフサイクルで動くからキャンセルを受け付けないよ")
        }
    }

    scope.launch {
        delay(1000)
        Log.i("launch", "兄弟にもキャンセルが伝播してくるよ")
    }

    val scope2 = CoroutineScope(Dispatchers.Default)

    scope2.launch {
        supervisorScope {
            launch {
                try {
                    throw Exception()
                }catch (e: Exception) {
                    Log.i("launch", "エラーが起きたよ")
                    scope.cancel()
                }
            }

            launch {
                Log.i("launch", "supervisorScopeを使うと他の子にキャンセルが伝播しなくなるよ")
            }
        }
    }


    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoroutineTheme {
        Greeting("Android")
    }
}