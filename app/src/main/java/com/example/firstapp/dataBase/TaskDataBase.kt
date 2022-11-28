package com.example.firstapp.dataBase

import android.content.Context
import androidx.room.Room
import javax.inject.Singleton

//наша локальная база данных реализуемая через синглтон
@Singleton
object TaskDataBase {

    lateinit var db: AppDataBase

    //функция инициализирующая базу данных
    fun initDB(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).build()
    }
}

