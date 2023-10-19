package com.waterseven.macro.lestari.presentation.auth

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.waterseven.macro.lestari.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            Masuk.setOnClickListener {
                val intent = Intent(this@RegisterActivity,SignInActivity::class.java)
                startActivity(intent)
            }
            btnConnectGoogle.setOnClickListener {
                Toast.makeText(this@RegisterActivity, "Fitur ini sedang dalam tahap pengembangan", Toast.LENGTH_SHORT).show()
            }
        }
    }

}