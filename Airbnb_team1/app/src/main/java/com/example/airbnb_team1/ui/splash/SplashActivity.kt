package com.example.airbnb_team1.ui.splash

import android.os.Handler
import android.os.Looper
import com.example.airbnb_team1.data.remote.auth.AuthService
import com.example.airbnb_team1.databinding.ActivitySplashBinding
import com.example.airbnb_team1.ui.BaseActivity
import com.example.airbnb_team1.ui.login.LoginActivity
import com.example.airbnb_team1.ui.main.MainActivity


class SplashActivity: BaseActivity<ActivitySplashBinding>(ActivitySplashBinding::inflate), SplashView {

    override fun initAfterBinding() {
        Handler(Looper.getMainLooper()).postDelayed({
            autoLogin()
        }, 2000)
    }

    private fun autoLogin() {
        AuthService.autoLogin(this)
    }

    override fun onAutoLoginLoading() {

    }

    override fun onAutoLoginSuccess() {
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onAutoLoginFailure(code: Int, message: String) {
        startActivityWithClear(LoginActivity::class.java)
    }
}