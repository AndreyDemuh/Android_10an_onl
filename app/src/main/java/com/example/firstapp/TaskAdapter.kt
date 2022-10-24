//package com.example.firstapp
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.firstapp.databinding.TaskItemBinding
//
//class TaskAdapter:RecyclerView.Adapter<TaskAdapter.TaskHolder>() {
//
//    private var taskList = listOf<Task>()
//
//
//    class TaskHolder(item: View): RecyclerView.ViewHolder(item) {
//        val binding = TaskItemBinding.bind(item)
//        fun bind(task: Task) = with(binding){
//            tvNameTask.text = task.nameTask
//            tvMessageTask.text = task.messageTask
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
//        return TaskHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: TaskHolder, position: Int) {
//        holder.bind(taskList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return taskList.size
//    }
//    fun setList(list: List <Task>){
//        taskList = list
//    }
//
//}

