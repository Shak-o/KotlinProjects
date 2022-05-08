package com.example.cheapyoutubeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView : BottomNavigationView
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavView)
        navController = findNavController(R.id.navHostFragment)

        setupActionBarWithNavController(navController, AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.notificationFragment,
                R.id.dashboardFragment
            )
        ))

        bottomNavigationView.setupWithNavController(navController)
    }
}