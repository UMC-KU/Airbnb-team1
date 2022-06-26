package com.example.airbnb_team1.ui.splash

interface SplashView {
    fun onAutoLoginLoading()
    fun onAutoLoginSuccess()
    fun onAutoLoginFailure(code: Int, message: String)
}