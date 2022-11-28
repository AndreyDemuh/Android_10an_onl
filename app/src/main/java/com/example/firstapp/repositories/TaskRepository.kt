package com.example.firstapp.repositories

import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.TaskEntity
import javax.inject.Inject

//промежуточный слой между нашей ViewModel и базой данных (нашим TaskDataBase)
class TaskRepository @Inject constructor(){

    //добавляем задачу в базу данных
    suspend fun addTasks(task: TaskEntity) {
        TaskDataBase.db.taskDao().insertTask(task)
    }

    //удаляем задачу из базы данных
    suspend fun deleteTask(id: Int) {
        TaskDataBase.db.taskDao().deleteTask(id)
    }

    //удаляем все задачи из базы данных
    suspend fun deleteAllListTasks(){
        return TaskDataBase.db.taskDao().deleteAllTask()
    }

    //функция которая умеет забирать перечень наших созданных задач
    suspend fun getListTasks(): ArrayList<TaskEntity> {
        return TaskDataBase.db.taskDao().selectAllTask() as ArrayList<TaskEntity>
    }
}
