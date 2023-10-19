package com.waterseven.macro.lestari

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.waterseven.macro.lestari.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            Handler(Looper.getMainLooper()).post {
                when (navDestination.id) {
                    R.id.homeFragment, R.id.watchFragment, R.id.communityFragment, R.id.profileFragment -> {
                        binding.bottomNav.visibility = View.VISIBLE
                    }
                    else -> {
                        binding.bottomNav.visibility = View.GONE
                    }
                }
            }
        }

        binding.bottomNav.setupWithNavController(navController)
    }
}