package com.example.firstapp.model

import java.io.Serializable
import java.util.*

//дата класс отображаемый только пользователю.
data class Task(
    val id: Int,
    val nameTask: String,
    val messageTask: String,
    val date: Date,
    val userEmail: String
) : Serializable
