package com.example.logiclumina

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.logiclumina.ui.screens.homepage.HomeScreen
import com.example.logiclumina.ui.theme.LogicLuminaTheme
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogicLuminaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color.Red
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                    ) {
                        Greeting()
                        CallToAction()
                        UserInteractionBox()
                        HomeScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    val greeting = when (LocalTime.now().hour) {
        in 5..11 -> "Good Morning"
        in 11..16 -> "Good Afternoon"
        in 16..20 -> "Good Evening"
        else -> "Good Night"
    }
    Text(
        text = "Welcome!\n$greeting",
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}
@Composable
fun CallToAction(modifier: Modifier = Modifier){
    Text(
        text = "Enter text below",
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInteractionBox(modifier: Modifier = Modifier){
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Text") }
    )
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LogicLuminaTheme {
        Greeting()
    }
}