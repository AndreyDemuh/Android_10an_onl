package com.example.firstapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.constance.Constance
import com.example.firstapp.databinding.FragmentAddTaskErrorBinding
import com.example.firstapp.ui.taskmanagement.AddTaskFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class AddTaskError : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentAddTaskErrorBinding
    val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskErrorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handler.postDelayed({
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddTaskFragment())
                .addToBackStack("")
                .commit()
        }, Constance.TIME_SLIDE_INFO_ADD_TASK)
    }
}
