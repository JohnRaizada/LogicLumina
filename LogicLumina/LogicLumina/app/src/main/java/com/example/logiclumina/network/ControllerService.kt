package com.example.logiclumina.network

import com.example.logiclumina.data.models.RecieveText
import com.example.logiclumina.data.models.SendText
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ControllerService {
    @POST("api/")
    fun postText(@Body sendText: SendText): Call<RecieveText>
    @GET("api/")
    fun getVideo(): Call<SendText>
}