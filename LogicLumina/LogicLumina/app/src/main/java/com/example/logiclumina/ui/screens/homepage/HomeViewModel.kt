package com.example.logiclumina.ui.screens.homepage

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.logiclumina.data.models.RecieveText
import com.example.logiclumina.data.models.SendText
import com.example.logiclumina.network.ControllerService
import com.example.logiclumina.network.ServiceBuilder
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class HomeViewModel: ViewModel() {
    val nomenclature = "HomeViewModel"
    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState: StateFlow<HomeUIState> = _uiState.asStateFlow()
    fun sendTextData(
        context: Context,
        sendText: SendText
    ){
        viewModelScope.launch {
            val controllerService = ServiceBuilder.buildService(ControllerService::class.java)
            val requestCall = controllerService.postText(sendText)
            requestCall.enqueue(object :
            retrofit2.Callback<RecieveText>{
                override fun onResponse(
                    call: Call<RecieveText>,
                    response: Response<RecieveText>
                ) {
                    if (response.isSuccessful){
                        Log.d(nomenclature, "Successfully sent user query")
                    }
                }
                override fun onFailure(
                    call: Call<RecieveText>,
                    t: Throwable
                ) {
                    Log.d(nomenclature, "There was an error while trying to send user query")
                    Log.i(nomenclature, "Error:\n$t")
                    Toast
                        .makeText(
                            context,
                            "Unable to connect with server",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            })
        }
    }
}