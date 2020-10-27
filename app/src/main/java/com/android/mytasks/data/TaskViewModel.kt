package com.android.mytasks.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskViewModel(application: Application) : AndroidViewModel(application) {

     var readAllTasks : LiveData<List<Task>>
    private var repository : TaskRepository
    var readLatestTask : LiveData<Task>

    init {
        val taskDao = TaskDatabase.getDatabase(application).taskDao()
        repository = TaskRepository(taskDao)
        readAllTasks = repository.readAllTasks
        readLatestTask = repository.readLatestTask
    }

    fun addTask(task: Task){
        viewModelScope.launch(Dispatchers.IO){
            repository.addTask(task)
        }
    }

    fun getCount(): LiveData<Int?>? {
        return repository.getCount()
    }
}