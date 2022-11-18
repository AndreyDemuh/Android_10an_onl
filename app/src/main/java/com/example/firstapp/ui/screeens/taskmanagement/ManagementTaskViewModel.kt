package com.example.firstapp.ui.screeens.taskmanagement

import androidx.lifecycle.ViewModel
import com.example.firstapp.model.TaskEntity
import com.example.firstapp.repositories.TaskRepository

//создали класс реализующий работу вью модели на нашем View (у нас AddTaskFragment)
class ManagementTaskViewModel : ViewModel() {

    //создали переменную repository, которая ссылается на слой TaskRepository()
    private val repository = TaskRepository()

    /**??????лямда выражение которое покажет успешно ли мы выполнили добавление задачи
     * ИЛИ Я НЕ ПРАВИЛЬНО ПОНЯЛ ЕЕ НАЗНАЧЕНИЕ???*/
    var taskAdded: (() -> Unit)? = null

    //функция которая добавляет нашу созданную задачу(Task) и передаем ее в нашу базу данных (TaskDataBase)
    suspend fun addTaskVM(
        taskName: String, taskMessage: String, taskDate: String, userEmail: String
    ) {
        repository.addTasks(TaskEntity(0, taskName, taskMessage, taskDate, userEmail))
        taskAdded?.invoke()
    }

    suspend fun deleteAllTask() {
        repository.deleteAllListTasks()
    }

    suspend fun deleteTask(id: Int) {
        repository.deleteTask(id)
    }
}