package com.example.firstapp.repositories

import android.content.Context
import androidx.core.content.edit


private const val USER_PREFERENCES = "user_preferences"
private const val GLOBAL_PREFERENCES = "global_preferences"
private const val USER_NAME = "user_name"
private const val USER_EMAIL = "user_email"

//создаем хранилище для нашего приложения
class SharePreferencesRepository(context: Context) {

    private val userPreferences =
        context.getSharedPreferences(USER_PREFERENCES, Context.MODE_PRIVATE)

    private val globalPreferences =
        context.getSharedPreferences(GLOBAL_PREFERENCES, Context.MODE_PRIVATE)

    //функция для записи имени пользователя
    fun setUserName(userName: String) {
        userPreferences.edit {
            putString(USER_NAME, userName)
        }
    }
    //функция для "получения" имени пользователя
    fun getUserName(): String? {
        return userPreferences.getString(USER_NAME, null)
    }

    //функция для записи email пользователя
    fun setUserEmail(userName: String) {
        userPreferences.edit {
            putString(USER_EMAIL, userName)
        }
    }
    //функция для "получения" email пользователя
    fun getUserEmail(): String? {
        return userPreferences.getString(USER_EMAIL, null)
    }

    fun deleteUser(){
        globalPreferences.edit{
            clear()
        }
    }
}