package com.example.task_androfund_aufalmuaffaq_mobileb_morning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    protected lateinit var etUsername:EditText
    protected lateinit var etPassword:EditText
    protected lateinit var etConfirmPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.edt_Username)
        etPassword = findViewById(R.id.edt_Password)
        etConfirmPassword = findViewById(R.id.edt_Confirm_Password)

        val btnRegister: Button = findViewById(R.id.btn_Register)
        btnRegister.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id. btn_Register-> {
                val bundle = Bundle()
                bundle.putString("Username",etUsername.text.toString())
                bundle.putString("Password",etPassword.text.toString())

                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}