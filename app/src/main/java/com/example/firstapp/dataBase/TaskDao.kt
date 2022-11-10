package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Task

// интерфейс DAO с описанием общих методов, которые будут использоваться при взаимодействии с базой данных
@Dao
interface TaskDao {

    @Insert                               //Метод с аннотацией Insert вставляет/добавляет объект в базу данных.
    fun insertTask(task: Task)

    @Delete                              //Метод с аннотацией Delete будет удалять объекты.
    fun deleteTask(task: Task)

//    @Delete
//    fun deleteAllTask(): List<Task>

    @Query("SELECT * FROM Task")        //Метод с аннотацией Query позволяет достать записи из базы данных по определенному запросу
    fun selectAllTask(): List<Task>

    @Query("SELECT * FROM Task WHERE userEmail LIKE :email")
    fun selectTaskByUser(email: String): List<Task>
}