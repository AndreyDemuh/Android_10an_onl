package com.example.firstapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.databinding.FragmentDeleteTaskBinding

class DeleteTasksFragment : Fragment() {

    private lateinit var binding: FragmentDeleteTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDeleteTaskBinding.inflate(inflater)
        return binding.root

    }


}