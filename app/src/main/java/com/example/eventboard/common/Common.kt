package com.example.eventboard.common

import com.example.eventboard.Interface.RetrofitServices
import com.example.eventboard.Retrofit.RetrofitClient

object Common {
    private val BASE_URL = "https://my-json-server.typicode.com/RomanEsin/DENIDB/db"
    val retrofitServices: RetrofitServices
        get() = RetrofitClient.getClient(BASE_URL).create(RetrofitServices::class.java)
}