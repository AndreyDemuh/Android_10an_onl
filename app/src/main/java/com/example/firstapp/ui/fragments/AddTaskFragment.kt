package com.example.firstapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.firstapp.*
import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.databinding.FragmentAddTaskBinding
import com.example.firstapp.model.Task

class AddTaskFragment : Fragment() {

    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdd.setOnClickListener { onAddNewTask() }

        binding.btnBack.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, TaskFragment())
                .commit()
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
        val taskName = view?.findViewById<EditText>(R.id.titlesContainer)?.text.toString()
        val taskMessage = view?.findViewById<EditText>(R.id.messageContainer)?.text.toString()
        val taskDate = view?.findViewById<EditText>(R.id.editTextDate)?.text.toString()
        val newTask = Task(taskName, taskMessage, taskDate)
        if (validate()) {
            TaskDataBase.listTask.add(newTask)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, TaskFragment())
                .addToBackStack("")
                .commit()
        }
    }
}



