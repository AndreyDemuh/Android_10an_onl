package com.example.firstapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nameTask")
    val nameTask: String,
    @ColumnInfo(name = "messageTask")
    val messageTask: String,
    @ColumnInfo(name = "data")
    val data: String,
    @ColumnInfo(name = "userEmail")
    val userEmail: String
) : Serializable
