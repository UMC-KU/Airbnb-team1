package com.example.airbnb_team1.data.remote.data

import android.util.Log
import com.example.airbnb_team1.ApplicationClass.Companion.retrofit
import com.example.airbnb_team1.ui.main.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRetrofitClass {

    fun getAll(fragment: HomeFragment){
        val dataRetrofitService = retrofit.create(DataInterface::class.java)

        dataRetrofitService.getAll().enqueue(object : Callback<DataResponse>{

            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                val resp = response.body()!!
                when(resp.code){
                    1000 -> {
                        fragment.loadComplete(resp.result)
                    }
                    else -> Log.d("isSuccess", resp.code.toString())
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                Log.d("isSuccess", "failure")
            }

        })

    }



}