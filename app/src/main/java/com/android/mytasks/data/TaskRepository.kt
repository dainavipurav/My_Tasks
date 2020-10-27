package com.android.mytasks.data

import androidx.lifecycle.LiveData

class TaskRepository(private val taskDao: TaskDao) {

    var readAllTasks : LiveData<List<Task>> = taskDao.readAllTasks()

    var readLatestTask : LiveData<Task> = taskDao.readLatestRecord()

    fun getCount(): LiveData<Int?>? {
        return taskDao.getCount()
    }

    suspend fun addTask(task: Task){
        taskDao.addTask(task)
    }
}