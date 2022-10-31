package com.example.firstapp.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import com.example.firstapp.constance.Constance
import com.example.firstapp.databinding.FragmentEnjoyBinding
import com.example.firstapp.ui.registration.SignUpFragment

class EnjoyFragment_6 : Fragment() {

    private lateinit var binding : FragmentEnjoyBinding
    val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEnjoyBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSkip6.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment())
                .addToBackStack("EnjoyFragment")
                .commit()
            handler.removeCallbacksAndMessages(null);
        }

        handler.postDelayed({
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, SignUpFragment())
                .addToBackStack("EnjoyFragment")
                .commit()
        }, Constance.TIME_SLIDE_ACTIVITY)
    }
}
