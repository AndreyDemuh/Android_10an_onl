package com.example.firstapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentStartAppBinding
import com.example.firstapp.ui.registration.LogInFragment

class StartAppFragment_1 : Fragment() {

    private lateinit var binding : FragmentStartAppBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartAppBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonStart.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, FindProjectFragment_2())
                .addToBackStack("StartFindActivity")
                .commit()
        }
        binding.btnLoginLauncher.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .addToBackStack("LogInActivity")
                .commit()
        }

    }
}
