package com.example.eventboard

import com.google.gson.annotations.SerializedName

data class EventData(
    @SerializedName("title")
    var name: String? = null,
    @SerializedName("start_data")
    var data: String? = null
)
