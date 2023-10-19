package com.waterseven.macro.lestari.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.waterseven.macro.lestari.MainActivity
import com.waterseven.macro.lestari.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
        moveToMain()
    }

    private fun moveToMain() {
        binding.apply {
            button.setOnClickListener {
                val intent = Intent(this@SignInActivity, MainActivity::class.java)
                startActivity(intent)
            }
            btnConnectGoogle.setOnClickListener {
                Toast.makeText(this@SignInActivity, "Fitur ini sedang dalam tahap pengembangan", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setUpView() {
        binding.apply {
            Daftar.setOnClickListener {
                val intent = Intent(this@SignInActivity,RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}