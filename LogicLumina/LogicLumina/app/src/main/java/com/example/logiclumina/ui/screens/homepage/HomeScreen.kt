package com.example.logiclumina.ui.screens.homepage

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import com.example.logiclumina.data.models.SendText

@Composable
fun HomeScreen(){
    val scope = rememberSaveable {
        mutableStateOf(true)
    }
    if (scope.value){
        scope.value = !scope.value
        HomeViewModel().sendTextData(
            context = LocalContext.current,
            sendText = SendText(
                text = "Hey There!"
            )
        )
    }
}