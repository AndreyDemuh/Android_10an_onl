package com.example.firstapp.repositories

import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.User

//репозиторий User'ов
class UserRepository {

    //добавляем User'а в базу данных
    suspend fun addUsers(user: User) {
        TaskDataBase.db.userDao().addUser(user)
    }

    //удаляем User'а из базы данных
    suspend fun deleteUser(email: String) {
        TaskDataBase.db.userDao().deleteUser(email)
    }

    //функция которая умеет забирать перечень наших созданных задач
    suspend fun getListUser(): ArrayList<User> {
        return TaskDataBase.db.userDao().getAllUser() as ArrayList<User>
    }
}
