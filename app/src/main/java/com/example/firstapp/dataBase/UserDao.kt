package com.example.firstapp.dataBase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("DELETE FROM users WHERE email = (:email)")
    suspend fun deleteUser(email: String)

    @Query("SELECT * FROM users")
    suspend fun getAllUser(): List<User>
}