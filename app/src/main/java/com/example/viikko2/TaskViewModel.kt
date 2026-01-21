package com.example.viikko2

import androidx.compose.runtime.mutableStateOf
import com.example.viikko2.domain.mockList
import com.example.viikko2.domain.Task
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class TaskViewModel : ViewModel() {

    var tasks by mutableStateOf(listOf<Task>())
        private set

    init {
        tasks = mockList
    }

    fun addTask(task: Task){
        tasks = tasks + task
    }

    fun toggleDone(id: Int){
        tasks = tasks.map {
            if (it.id == id) it.copy (done = !it.done) else it
        }
    }

    fun filterByDone(done: Boolean){
        tasks = tasks.filter { it.done == done }
    }

    fun sortDueDate (){
        tasks = tasks.sortedBy { it.dueDate }
    }

    fun removeTask(id: Int){
        tasks = tasks.filter{it.id != id}
        }

    fun reset(){
        tasks = mockList
    }
}