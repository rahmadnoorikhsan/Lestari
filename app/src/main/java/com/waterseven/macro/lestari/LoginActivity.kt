package com.example.task_androfund_aufalmuaffaq_mobileb_morning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.waterseven.macro.lestari.MainActivity
import com.waterseven.macro.lestari.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    protected lateinit var etUsername: EditText
    protected lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.edt_Username)
        etPassword = findViewById(R.id.edt_Password)

        val bundle = intent.extras
        if (bundle != null) {
            etUsername.setText(bundle.getString("Username"))
            etPassword.setText(bundle.getString("Password"))
        }
        val btnLogin: Button = findViewById(R.id. btn_Login)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            when (v.id){
                R.id.btn_Login -> {
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}