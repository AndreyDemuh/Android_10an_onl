package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Task
import com.example.firstapp.model.User

@Dao
interface UserDao {

    @Insert
    fun addUser(user: User)

//    @Delete
//    fun deleteUser(user: User)

    @Query("SELECT * FROM user")
    fun getAllUser(): List<User>
}