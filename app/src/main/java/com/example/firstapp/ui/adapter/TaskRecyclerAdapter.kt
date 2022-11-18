package com.example.firstapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.model.Task

/** создаем класс адаптер, который преобразует все полученные данные в наш список RecyclerView
 * (берет данные из класса TaskViewHolder, создает ячейку списка в методе onCreateViewHolder и
 * заполняет ее через метод onBindViewHolder*/

class TaskRecyclerAdapter(
    private val onClick: (task: Task) -> Unit
) : RecyclerView.Adapter<TaskViewHolder>() {

    private var taskList = arrayListOf<Task>()

    /**создает новый объект ViewHolder,
     * т.е. создаётся layout строки списка (разметка из task_item), передается объекту ViewHolder,
     * и каждый дочерний view-компонент может быть найден и сохранен.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        )
    }

    /** принимает объект ViewHolder и устанавливает необходимые данные для соответствующей строки во view-компоненте*/
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(taskList[position])
        holder.itemView.setOnClickListener {
            onClick(taskList[position])
        }
    }

    /** возвращает общее количество элементов списка*/
    override fun getItemCount(): Int {
        return taskList.size
    }

    /** добавляет созданную задачу в наш список*/
    @SuppressLint("NotifyDataSetChanged")
    fun addNewTask(taskList: ArrayList<Task>) {
        this.taskList = taskList
        notifyDataSetChanged()
    }

}