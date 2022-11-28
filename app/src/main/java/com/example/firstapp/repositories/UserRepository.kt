package com.example.firstapp.repositories

import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.User
import javax.inject.Inject

//репозиторий User'ов
class UserRepository @Inject constructor(){

    //добавляем User'а в базу данных

    suspend fun addUsers(user: User) {
        TaskDataBase.db.userDao().addUser(user)
    }

    //удаляем User'а из базы данных
    suspend fun deleteUser(email: String) {
        TaskDataBase.db.userDao().deleteUser(email)
    }
}
