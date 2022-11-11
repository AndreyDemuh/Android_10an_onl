package com.example.firstapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.databinding.FragmentTaskBinding
import com.example.firstapp.ui.adapter.TaskRecyclerAdapter
import com.example.firstapp.ui.fragments.TaskInfoFragment.Companion.getTaskInfoInstance
import com.example.firstapp.ui.registration.LogInFragment

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAddNew.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AddTaskFragment())
                .addToBackStack("")
                .commit()
        }
        binding.btnLogout.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, LogInFragment())
                .addToBackStack("")
                .commit()
        }

        binding.rcTaskView.run {
            adapter = TaskRecyclerAdapter {
                getTaskInfoInstance(it.nameTask, it.messageTask, it.data)
                    .show(childFragmentManager, "")
            }
            layoutManager = LinearLayoutManager(requireContext())
            (adapter as TaskRecyclerAdapter).addTask(TaskDataBase.listTask)
        }
    }
}

