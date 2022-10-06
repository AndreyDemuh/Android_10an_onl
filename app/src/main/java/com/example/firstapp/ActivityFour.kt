package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button

class ActivityFour : AppCompatActivity() {

    val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)

        handler.postDelayed({
            startActivity(Intent(this, ActivityFive::class.java))
            finish()
        }, 10000)

        val buttonSkip4 = findViewById<Button>(R.id.btn_skip4)
        buttonSkip4.setOnClickListener(::onClickSkip4)
    }

    private fun onClickSkip4(view: View) {
        startActivity(Intent(this, ActivityFive::class.java))
        handler.removeCallbacksAndMessages(null);
    }
}
