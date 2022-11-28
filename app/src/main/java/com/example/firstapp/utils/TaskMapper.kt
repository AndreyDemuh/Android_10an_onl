package com.example.firstapp.utils

import com.example.firstapp.model.Task
import com.example.firstapp.model.TaskEntity

fun TaskEntity.toTask(): Task =
    Task(id, nameTask, messageTask, date, userEmail)

fun ArrayList<TaskEntity>.toListTask(): ArrayList<Task> =
    this.map { it.toTask() } as ArrayList<Task>