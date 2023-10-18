package com.waterseven.macro.lestari.presentation.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.waterseven.macro.lestari.R
import com.waterseven.macro.lestari.databinding.ActivityRagisterBinding

class RagisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRagisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRagisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpView()
    }

    private fun setUpView() {
        binding.apply {
            Masuk.setOnClickListener {
                val intent = Intent(this@RagisterActivity,SignInActivity::class.java)
                startActivity(intent)
            }
        }
    }

}