package com.example.firstapp.ui.taskmanagement

import androidx.lifecycle.ViewModel
import com.example.firstapp.model.Task
import com.example.firstapp.repositories.TaskRepository

//создали класс реализующий работу вью модели на нашем View по удалению задачи (у нас DeleteTasksFragment)
class DeleteTaskViewModel: ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = TaskRepository()

    var taskDeleted: (() -> Unit)? = null

    //функция которая удаляет нашу созданную задачу(Task) из базы данных (TaskDataBase)
//    fun deleteTaskVM(taskName: String, taskMessage: String, taskDate: String){
//        repository.deleteTask(Task(0, taskName, taskMessage,taskDate))
//        taskDeleted?.invoke()
//    }
}
