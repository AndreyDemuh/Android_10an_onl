package com.example.firstapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ActivityTwo : AppCompatActivity() {

    val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)

        handler.postDelayed({
            startActivity(Intent(this, ActivityThree::class.java))
            finish()
        }, 10000)

        val buttonSkip2 = findViewById<Button>(R.id.btn_skip2)
        buttonSkip2.setOnClickListener(::onClickSkip2)
    }

    private fun onClickSkip2(view: View) {
        startActivity(Intent(this, ActivityThree::class.java))
        handler.removeCallbacksAndMessages(null);
    }

}



