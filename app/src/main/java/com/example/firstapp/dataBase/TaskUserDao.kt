package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Query
import com.example.firstapp.model.TaskEntity

@Dao
interface TaskUserDao {

    //запрос на выбор всех заметок пренадлежащих пользователю на основании его Email
    @Query("SELECT * FROM tasks ")
    fun getTaskByUser(): List<TaskEntity>

}