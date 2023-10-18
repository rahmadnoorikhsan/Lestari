package com.waterseven.macro.lestari.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            Daftar.setOnClickListener {
                val intent = Intent(this@SignInActivity,RagisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}