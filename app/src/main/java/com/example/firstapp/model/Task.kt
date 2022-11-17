package com.example.firstapp.model

import java.io.Serializable

//дата класс отображаемый только пользователю.
data class Task(
    val id: Int,
    val nameTask: String,
    val messageTask: String,
    val data: String,
    val userEmail: String
) : Serializable
