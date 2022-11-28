package com.example.firstapp

import android.app.Application
import com.example.firstapp.dataBase.TaskDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {

    //проинициализировали созданную базу данных (TaskDataBase)
    override fun onCreate() {
        super.onCreate()
        TaskDataBase.initDB(applicationContext)
    }
}