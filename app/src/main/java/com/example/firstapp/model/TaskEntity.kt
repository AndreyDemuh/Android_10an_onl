package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nameTask")
    val nameTask: String,
    @ColumnInfo(name = "messageTask")
    val messageTask: String,
    @ColumnInfo(name = "data")
    val date: Date,
    @ColumnInfo(name = "userEmail")
    val userEmail: String
): Serializable