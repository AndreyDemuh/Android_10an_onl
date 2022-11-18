package com.example.firstapp

import android.app.Application
import com.example.firstapp.dataBase.TaskDataBase

class App : Application() {

    //проинициализировали созданную базу данных (TaskDataBase)
    override fun onCreate() {
        super.onCreate()
        TaskDataBase.initDB(applicationContext)
    }
}