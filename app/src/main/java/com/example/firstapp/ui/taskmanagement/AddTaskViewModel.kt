package com.example.firstapp.ui.taskmanagement

import androidx.lifecycle.ViewModel
import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.Task
import com.example.firstapp.repositories.TaskRepository

//создали класс реализующий работу вью модели на нашем View (у нас AddTaskFragment)
class AddTaskViewModel : ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = TaskRepository()

    /**??????лямда выражение которое покажет успешно ли мы выполнили добавление задачи
     * ИЛИ Я НЕ ПРАВИЛЬНО ПОНЯЛ ЕЕ НАЗНАЧЕНИЕ???*/
    var taskAdded: (() -> Unit)? = null

    //функция которая добавляет нашу созданную задачу(Task) и передаем ее в нашу базу данных (TaskDataBase)
    fun addTaskVM(taskName: String, taskMessage: String, taskDate: String, userEmail: String) {
        repository.addTasks(Task(0, taskName, taskMessage, taskDate, userEmail))
        taskAdded?.invoke()
    }
}