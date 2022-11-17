package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.TaskEntity

// интерфейс DAO с описанием общих методов, которые будут использоваться при взаимодействии с базой данных
@Dao
interface TaskDao {

    @Insert                               //Метод с аннотацией Insert вставляет/добавляет объект в базу данных.
    suspend fun insertTask(task: TaskEntity)

    @Query("DELETE FROM tasks WHERE id = (:id)")   //Метод с аннотацией Delete будет удалять объекты.
    suspend fun deleteTask(id: Int)

    @Query("DELETE FROM tasks ") //Метод на удаление всех задач
    suspend fun deleteAllTask()

    @Query("SELECT * FROM tasks")        //Метод с аннотацией Query позволяет достать записи из базы данных по определенному запросу
    suspend fun selectAllTask(): List<TaskEntity>

    @Query("SELECT * FROM tasks WHERE userEmail LIKE :email")
    fun selectTaskByUser(email: String): List<TaskEntity>
}