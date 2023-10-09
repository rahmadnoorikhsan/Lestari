package com.waterseven.macro.lestari

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waterseven.macro.lestari.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNav.setOnClickListener { item ->
            when(item.id) {
                R.id.homeFragment -> {}
                R.id.watchFragment -> {}
                R.id.communityFragment -> {}
                R.id.profileFragment -> {}
            }
        }
    }
}