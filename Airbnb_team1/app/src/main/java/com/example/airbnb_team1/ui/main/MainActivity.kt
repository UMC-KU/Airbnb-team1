package com.example.airbnb_team1.ui.main

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.airbnb_team1.R
import com.example.airbnb_team1.databinding.ActivityMainBinding
import com.example.airbnb_team1.ui.BaseActivity
import com.example.airbnb_team1.ui.main.home.HomeFragment
import com.example.airbnb_team1.ui.main.message.MessageFragment
import com.example.airbnb_team1.ui.main.profile.ProfileFragment
import com.example.airbnb_team1.ui.main.travel.TravelFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val fragment1= HomeFragment()
        val fragment2=TravelFragment()
        val fragment3=MessageFragment()
        val fragment4=ProfileFragment()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 하단 탭이 눌렸을 때 화면을 전환하기 위해선 이벤트 처리하기 위해 BottomNavigationView 객체 생성
        var bnv_main = findViewById(R.id.bnv_main) as BottomNavigationView

        // OnNavigationItemSelectedListener를 통해 탭 아이템 선택 시 이벤트를 처리
        // navi_menu.xml 에서 설정했던 각 아이템들의 id를 통해 알맞은 프래그먼트로 변경하게 한다.
        bnv_main.run { setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.first -> {
                    // 다른 프래그먼트 화면으로 이동하는 기능
                    val homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment1).commit()
                }
                R.id.second -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment2).commit()
                }
                R.id.third -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment3).commit()
                }
                R.id.forth -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fl_container, fragment4).commit()
                }
            }
            true
        }
            selectedItemId = R.id.first
        }
    }
}