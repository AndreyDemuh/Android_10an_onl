package com.example.firstapp.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.firstapp.model.TaskEntity
import com.example.firstapp.model.User
import com.example.firstapp.utils.DateConverter

//база данных приложения
@Database(entities = [TaskEntity::class, User::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    abstract fun userDao(): UserDao

    abstract fun taskUserDao(): TaskUserDao
}