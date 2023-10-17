package com.example.eletric_car_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.eletric_car_app.R
import com.example.eletric_car_app.R.id.unique_nav_host_fragment
import com.example.eletric_car_app.data.CarFactory
import com.example.eletric_car_app.databinding.ActivityMainBinding
import com.example.eletric_car_app.ui.Adapter.CarAdapter
import com.example.eletric_car_app.ui.Adapter.TabAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupListeners()
        val navController = findNavController(R.id.unique_nav_host_fragment)
        setupWithNavController(binding.bottomNavigation, navController)
    }
    fun setupListeners() {
        binding.fabCalcular.setOnClickListener {
            startActivity(Intent(this, CalculaAutonomiaActivity::class.java))
        }
    }



}