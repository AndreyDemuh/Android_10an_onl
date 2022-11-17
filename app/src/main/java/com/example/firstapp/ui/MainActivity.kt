package com.example.firstapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityMainBinding
import com.example.firstapp.ui.screeens.StartAppFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, StartAppFragment())
            .addToBackStack("")
            .commit()
    }
}



