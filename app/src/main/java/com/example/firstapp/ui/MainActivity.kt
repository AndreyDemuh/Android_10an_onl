package com.example.firstapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.ui.fragments.StartAppFragment_1

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, StartAppFragment_1())
            .addToBackStack("")
            .commit()

    }
}

//        supportFragmentManager.beginTransaction()
//            .replace(R.id.container, FindProject_fragment_2())
//            .commit()

//        val buttonStart = findViewById<Button>(R.id.button_start)
//        buttonStart.setOnClickListener{
//            startActivity(Intent(this, FindProjectActivity::class.java))
//        }
//        val buttonLogin = findViewById<Button>(R.id.btn_loginLauncher)
//        buttonLogin.setOnClickListener{
//            startActivity(Intent(this, LogInActivity::class.java))
//        }


