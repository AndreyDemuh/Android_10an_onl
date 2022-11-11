package com.example.firstapp.repositories

import com.example.firstapp.dataBase.TaskDataBase
import com.example.firstapp.model.User

//репозиторий User'ов
class UserRepository {

    //добавляем User'а в базу данных
    fun addUser(user: User) {
        TaskDataBase.db.userDao().addUser(user)
    }

    //удаляем User'а из базы данных
//    fun deleteUser(user: User) {
//        TaskDataBase.db.userDao().deleteUser(user)
//    }

    //функция которая умеет забирать перечень наших созданных задач
    fun getListUser(): ArrayList<User> {
        return TaskDataBase.db.userDao().getAllUser() as ArrayList<User>
    }
}
