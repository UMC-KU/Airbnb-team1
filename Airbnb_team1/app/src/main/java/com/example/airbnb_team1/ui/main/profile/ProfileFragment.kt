package com.example.airbnb_team1.ui.main.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import com.example.airbnb_team1.R
import com.example.airbnb_team1.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_profile,container,false)
        binding = FragmentProfileBinding.inflate(inflater,container,false)
        binding.profileProfileBtn.setOnClickListener {
            val intent = Intent(activity,DetailActivity::class.java)
            startActivity(intent)
        }
        return binding.root
    }


}