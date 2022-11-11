package com.example.firstapp.ui.fragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.firstapp.R
import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.databinding.FragmentProfileBinding
import com.example.firstapp.repositories.SharePreferencesRepository
import com.example.firstapp.ui.registration.LogInFragment
import com.example.firstapp.ui.taskmanagement.AddTaskFragment


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharePreferencesRepository = SharePreferencesRepository(requireContext())
        binding.tvProfileName.text = sharePreferencesRepository.getUserName()

        binding.deleteProfile.setOnClickListener {onClickDeleteAccount()}

        binding.profileLogout.setOnClickListener {onClickLogout()}

        binding.amountTask.text = TaskDataBase.db.taskDao().selectAllTask().size.toString()

        binding.bottomNavigationMenu.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.profileMenu -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .commit()
                    true
                }
                R.id.taskMenu -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, TaskFragment())
                        .commit()
                    true
                }
                R.id.searchMenu -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, SearchTaskFragment())
                        .commit()
                    true
                }
                R.id.addTaskMenu -> {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container, AddTaskFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
    fun onClickDeleteAccount() {
        val sharePreferencesRepository = SharePreferencesRepository(requireContext())
        AlertDialog.Builder(requireContext())
            .setMessage(R.string.delete_accaunt)
            .setPositiveButton(R.string.btn_delete) { _, _ ->
                sharePreferencesRepository.deleteUser()
                Toast.makeText(requireContext(), R.string.accaunt_deleted, Toast.LENGTH_SHORT).show()
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, LogInFragment())
                    .commit()
            }
            .setNegativeButton(R.string.btn_cancel) { _, _ ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment())
                    .addToBackStack("")
                    .commit()
            }
            .show()
    }

    fun onClickLogout() {
        AlertDialog.Builder(requireContext())
            .setMessage(R.string.logoyt_accaunt)
            .setPositiveButton(R.string.btn_exit) { _, _ ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, LogInFragment())
                    .commit()
            }
            .setNegativeButton(R.string.btn_cancel) { _, _ ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ProfileFragment())
                    .addToBackStack("")
                    .commit()
            }
            .show()
    }
}