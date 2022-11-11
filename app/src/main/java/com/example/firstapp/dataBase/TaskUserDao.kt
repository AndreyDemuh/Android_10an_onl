package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Query
import com.example.firstapp.model.Task
import com.example.firstapp.model.User

@Dao
interface TaskUserDao {

    //запрос на выюор всех заметок пренадлежащих пользователю на основании его Email
    @Query("SELECT * FROM User JOIN Task ON User.email = Task.userEmail")
    fun getTaskByUser(): Map<User, List<Task>>

}