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
import com.example.firstapp.databinding.FragmentChatBinding

class ChatFragment_4 : Fragment() {

    private lateinit var binding : FragmentChatBinding
    val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSkip4.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, WorkHardFragment_5())
                .addToBackStack("WorkFragment")
                .commit()
            handler.removeCallbacksAndMessages(null);
        }

        handler.postDelayed({
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, WorkHardFragment_5())
                .addToBackStack("WorkFragment")
                .commit()
        }, Constance.TIME_SLIDE_ACTIVITY)
    }
}

