package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ActivityEight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eight)

        val buttonSignUp = findViewById<Button>(R.id.btn_signUpReturn)
        buttonSignUp.setOnClickListener{
            startActivity(Intent(this, ActivitySeven::class.java))
        }
    }
}
