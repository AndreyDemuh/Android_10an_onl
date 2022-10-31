package com.example.firstapp.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
//import com.example.firstapp.RegistrationActivity.LogInActivity
import com.example.firstapp.databinding.FragmentTaskBinding
import com.example.firstapp.model.Task
//import com.example.firstapp.fragment.AddTaskFragment
import com.example.firstapp.ui.registration.LogInFragment

class TaskActivity : AppCompatActivity() {

    lateinit var bindingClass: FragmentTaskBinding

    private val adapter = TaskRecyclerAdapter{
        startActivity(Intent(this@TaskActivity, TaskInfoActivity::class.java).
        apply {
            putExtra("TaskName", it.nameTask)
            putExtra("MessageTask", it.messageTask)
        })}

    private var editLauncher: ActivityResultLauncher<Intent>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = FragmentTaskBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.btnLogout.setOnClickListener {
        startActivity(Intent(this, LogInFragment::class.java))
        }

        init()

        editLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                adapter.addTask(it.data?.getSerializableExtra("task") as Task)
            }
        }
        val categoryTask = resources.getStringArray(R.array.array_category_task)
        val spinner = bindingClass.spinnerCategoryTask
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryTask)
        spinner.adapter = adapter

    }

    private fun init() {
        bindingClass.apply {
            rcTaskView.layoutManager = LinearLayoutManager(this@TaskActivity)
            rcTaskView.adapter = adapter
            btnAddNew.setOnClickListener {
                editLauncher?.launch(Intent(this@TaskActivity, AddNoteActivity::class.java))
            }
        }
    }
}
