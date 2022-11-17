package com.example.firstapp.dataBase

import android.content.Context
import androidx.room.Room

//наша локальная база данных реализуемая через синглтон
object TaskDataBase {

    lateinit var db: AppDataBase

    //функция инициализирующая базу данных
    fun initDB(context: Context) {
        db = Room.databaseBuilder(
            context,
            AppDataBase::class.java, "database-name"
        ).allowMainThreadQueries().build()
    }
}

