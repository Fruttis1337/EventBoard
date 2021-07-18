package com.example.eventboard.Interface

import com.example.eventboard.Events
import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {
    @GET("events")
    fun getEvents(): Call<MutableList<Events>>
}