package com.example.airbnb_team1.ui.main.home

import com.google.gson.annotations.SerializedName

data class HomeDetailData(
    @SerializedName("accom_id")
    var id: Int,

    @SerializedName("accom_name")
    var name: String,

    @SerializedName("accom_address")
    var address: String,

    @SerializedName("price")
    var price: Int,

    @SerializedName("accomImgs")
    var imgData: ArrayList<AccomImgData>
)


data class AccomImgData(
    @SerializedName("accomImg_id")
    var id: Int,

    @SerializedName("accomImg_url")
    var url: String
)
