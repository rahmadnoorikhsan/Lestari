package com.waterseven.macro.lestari

import android.os.Bundle
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

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.main_nav_host) as NavHostFragment
        val navController = navHostFragment.navController

        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            if (navDestination.id == R.id.homeFragment || navDestination.id == R.id.watchFragment || navDestination.id == R.id.communityFragment || navDestination.id == R.id.profileFragment) {
                binding.bottomNav.visibility = View.VISIBLE
            } else {
                binding.bottomNav.apply {
                    visibility = View.GONE
                }
            }
        }

        binding.bottomNav.setupWithNavController(navController)
    }
}