package com.example.task_androfund_aufalmuaffaq_mobileb_morning

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.waterseven.macro.lestari.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnImplicit: Button = findViewById(R.id.btn_Implicit)
        btnImplicit.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id){
            R.id. btn_Implicit -> {
                val message = "Terima Kasih"
                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"
                startActivity(intent)
            }
        }
    }
}