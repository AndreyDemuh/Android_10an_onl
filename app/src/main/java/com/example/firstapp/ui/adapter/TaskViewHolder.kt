package com.example.firstapp.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.TaskItemBinding
import com.example.firstapp.model.Task
import com.example.firstapp.model.TaskEntity

/** класс который берет элементы и показывает их в RecyclerView по нашим созданным шаблонам в task_item*/
class TaskViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = TaskItemBinding.bind(view)

    fun bind(task: Task) = with(binding) {
        tvNameTask.text = task.nameTask
        tvMessageTask.text = task.messageTask
        tvDateTask.text = task.data
    }
}