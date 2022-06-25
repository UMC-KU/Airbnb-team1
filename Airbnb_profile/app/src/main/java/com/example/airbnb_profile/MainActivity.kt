package com.example.airbnb_profile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.airbnb_profile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btn = findViewById<Button>(R.id.btn)

//        btn.setOnClickListener {
//            val profilefragment = ProfileFragment()
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.f,profilefragment)
//                .commit()
//        }


    }
}