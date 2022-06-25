package com.example.airbnb_team1.utils

import com.example.airbnb_team1.ApplicationClass.Companion.X_ACCESS_TOKEN
import com.example.airbnb_team1.ApplicationClass.Companion.mSharedPreferences


fun saveJwt(jwtToken: String) {
    val editor = mSharedPreferences.edit()
    editor.putString(X_ACCESS_TOKEN, jwtToken)

    editor.apply()
}

fun getJwt(): String? = mSharedPreferences.getString(X_ACCESS_TOKEN, null)
