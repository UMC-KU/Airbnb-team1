package com.example.airbnb_team1.ui.main

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.airbnb_team1.R
import com.example.airbnb_team1.data.remote.data.DataRetrofitClass
import com.example.airbnb_team1.databinding.ActivityMainBinding
import com.example.airbnb_team1.ui.BaseActivity
import com.example.airbnb_team1.ui.main.home.HomeDetailData


class MainActivity: BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navHostFragment: NavHostFragment

    override fun initAfterBinding() {
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController: NavController = navHostFragment.findNavController()

        binding.mainBottomNavigation.setupWithNavController(navController)
    }

}