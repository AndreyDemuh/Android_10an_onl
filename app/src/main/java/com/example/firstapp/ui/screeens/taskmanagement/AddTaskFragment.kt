package com.example.firstapp.ui.screeens.taskmanagement

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.firstapp.*
import com.example.firstapp.constance.Constance
import com.example.firstapp.databinding.FragmentAddTaskBinding
import com.example.firstapp.repositories.SharePreferencesRepository
import com.example.firstapp.ui.screeens.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding
    private val viewModel: ManagementTaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener { onAddNewTask() }

        binding.imgCalendar.setOnClickListener {
            val cal = Calendar.getInstance()
            val myYear = cal.get(Calendar.YEAR)
            val myMonth = cal.get(Calendar.MONTH)
            val myYDay = cal.get(Calendar.DAY_OF_MONTH)
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    binding.btnDatePicker.text =
                        "Дата: " + dayOfMonth + "/" + (month + 1) + "/" + year
                },
                myYear,
                myMonth,
                myYDay
            )
            datePickerDialog.show()
        }

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

    //функция проверяющая результат валидации полей Title и Message
    private fun validate(): Boolean {
        val isTitleTaskValid = validateTitleTask()
        val isMessageTaskValid = validateMessageTask()
        return isTitleTaskValid == null && isMessageTaskValid == null
    }

    //функция принимающая результат валидации поля Title (пустое либо нет)
    private fun validateTitleTask(): String? {
        val titleTaskInputLayout = binding.titleContainer
        titleTaskInputLayout.let {
            val result = validateTitleTasks(it.text.toString())
            return when (result) {
                is Invalid -> {
                    titleTaskInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    titleTaskInputLayout.error = null
                    null
                }
            }
        }
    }

    //функция принимающая результат валидации поля Message (пустое либо нет)
    private fun validateMessageTask(): String? {
        val messageTaskInputLayout = binding.messageContainer
        messageTaskInputLayout.let {
            val result = validateMessageTasks(it.text.toString())
            return when (result) {
                is Invalid -> {
                    messageTaskInputLayout.error = this.getString(result.textError)
                    this.getString(result.textError)
                }
                else -> {
                    messageTaskInputLayout.error = null
                    null
                }
            }
        }
    }

    //функция которая добавляет созданную задачу, при условии что поля провалидированы
    private fun onAddNewTask() = with(binding) {
        if (validate()) {
            val sharedPreferencesRepository = SharePreferencesRepository(requireContext())
            val taskName = titleContainer.text.toString()
            val taskMessage = messageContainer.text.toString()
            val taskDate = btnDatePicker.text.toString()
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.addTaskVM(
                    taskName,
                    taskMessage,
                    taskDate,
                    sharedPreferencesRepository.getUserEmail() ?: ""
                )
            }
            binding.tvReportAddTaskOk.visibility = View.VISIBLE
            lifecycleScope.launch(Dispatchers.Main) {
                delay(Constance.TIME_SLIDE_INFO_ADD_TASK)
                binding.tvReportAddTaskOk.visibility = View.GONE
            }
            binding.titleContainer.setText("")
            binding.messageContainer.setText("")
            binding.btnDatePicker.setText(R.string.choose_date)
        } else {

            binding.tvReportAddTaskFalse.visibility = View.VISIBLE
            lifecycleScope.launch(Dispatchers.Main) {
                delay(Constance.TIME_SLIDE_INFO_ADD_TASK)
                binding.tvReportAddTaskFalse.visibility = View.GONE
            }
        }
    }
}


