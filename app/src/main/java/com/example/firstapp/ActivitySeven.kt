package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivitySeven : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven)

        val buttonLogin = findViewById<Button>(R.id.btn_loginLauncher)
        buttonLogin.setOnClickListener{
            startActivity(Intent(this, ActivityEight::class.java))
        }
    }
}
