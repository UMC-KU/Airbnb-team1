package com.example.airbnb_team1.data.remote.data

import com.example.airbnb_team1.ui.main.home.AccomImgData
import com.example.airbnb_team1.ui.main.home.HomeDetailData
import com.google.gson.annotations.SerializedName


data class DataResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: ArrayList<HomeDetailData>

)
