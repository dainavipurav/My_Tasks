package com.android.mytasks.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_table")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val taskTitle : String,
    val taskDescription : String
)