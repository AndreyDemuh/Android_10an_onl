package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Query
import com.example.firstapp.model.TaskEntity
import com.example.firstapp.model.User

@Dao
interface TaskUserDao {

    /** тут возвращается список всех пользователей, лучше добавить выборку только по текущему пользователю*/
//    @Query("SELECT * FROM User JOIN Task ON User.email = Task.userEmail") // так было
    //запрос на выбор всех заметок пренадлежащих пользователю на основании его Email
    @Query("SELECT * FROM tasks ")
    fun getTaskByUser(): List<TaskEntity>

//    @Query("SELECT * FROM User JOIN TaskEntity ON User.email = TaskEntity.userEmail WHERE User.email LIKE :userEmail")
//    fun getTaskByUsers(userEmail: String): Map<User, List<TaskEntity>>

}