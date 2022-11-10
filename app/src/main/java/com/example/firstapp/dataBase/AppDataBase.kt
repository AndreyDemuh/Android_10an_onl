package com.example.firstapp.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.firstapp.model.Task
import com.example.firstapp.model.User

//база данных приложения
@Database(entities = [Task::class, User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun userDao(): UserDao

    abstract fun taskUserDao(): TaskUserDao
}