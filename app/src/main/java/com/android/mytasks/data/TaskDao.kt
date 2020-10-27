package com.android.mytasks.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addTask(task: Task)

    @Query("SELECT * FROM task_table ORDER BY id DESC")
    fun readAllTasks() : LiveData<List<Task>>

    @Query("SELECT COUNT(*) FROM task_table")
    fun getCount(): LiveData<Int?>?

    @Query("SELECT * FROM task_table ORDER BY id DESC LIMIT 1")
    fun readLatestRecord() : LiveData<Task>
}