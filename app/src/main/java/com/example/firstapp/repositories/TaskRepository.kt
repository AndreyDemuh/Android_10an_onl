package com.example.firstapp.repositories

import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.Task

//промежуточный слой между нашей ViewModel и базой данных (нашим TaskDataBase)
class TaskRepository {

    //добавляем задачу в базу данных
    fun addTasks(task: Task) {
        TaskDataBase.db.taskDao().insertTask(task)
    }

    //удаляем задачу из базы данных
    fun deleteTask(task: Task) {
        TaskDataBase.db.taskDao().deleteTask(task)
    }

    //удаляем все задачи из базы данных
//    fun deleteAllListTasks(): ArrayList<Task> {
//        return TaskDataBase.db.taskDao().deleteAllTask() as ArrayList<Task>
//    }

    //функция которая умеет забирать перечень наших созданных задач
    fun getListTasks(): ArrayList<Task> {
        val list = TaskDataBase.db.taskUserDao().getTaskByUser()
        return TaskDataBase.db.taskDao().selectAllTask() as ArrayList<Task>
    }
}