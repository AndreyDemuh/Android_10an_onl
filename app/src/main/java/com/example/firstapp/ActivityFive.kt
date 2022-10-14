package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button

class ActivityFive : AppCompatActivity() {

    val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_five)

        handler.postDelayed({
            startActivity(Intent(this, ActivitySix::class.java))
            finish()
        }, 10000)

        val buttonSkip5 = findViewById<Button>(R.id.btn_skip5)
        buttonSkip5.setOnClickListener(::onClickSkip5)
    }


    private fun onClickSkip5(view: View) {
        startActivity(Intent(this, ActivitySix::class.java))
        handler.removeCallbacksAndMessages(null);
    }
}
