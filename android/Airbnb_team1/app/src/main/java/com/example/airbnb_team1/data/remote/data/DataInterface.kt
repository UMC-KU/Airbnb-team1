package com.example.airbnb_team1.data.remote.data

import retrofit2.Call
import retrofit2.http.GET

interface DataInterface {
    @GET("/accom/all")
    fun getAll(): Call<DataResponse>
}