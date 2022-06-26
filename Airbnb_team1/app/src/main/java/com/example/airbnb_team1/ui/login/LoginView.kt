package com.example.airbnb_team1.ui.login

import com.example.airbnb_team1.data.remote.auth.Auth


interface LoginView {
    fun onLoginLoading()
    fun onLoginSuccess(auth: Auth)
    fun onLoginFailure(code: Int, message: String)
}