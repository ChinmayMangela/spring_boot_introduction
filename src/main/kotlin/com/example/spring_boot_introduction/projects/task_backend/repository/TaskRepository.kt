package com.example.spring_boot_introduction.projects.task_backend.repository

import com.example.spring_boot_introduction.projects.task_backend.model.Task
import org.springframework.stereotype.Repository
import java.util.concurrent.ConcurrentHashMap


@Repository
class TaskRepository {

    private val tasks = ConcurrentHashMap<String, Task>();

    fun addTask(task: Task) {
        tasks[task.id] = task
    }

    fun getTask(id: String): Task? {
        return tasks[id]
    }

    fun getAllTasks(): List<Task> {
        return tasks.values.toList();
    }

    fun updateTask(id: String, task: Task): Boolean {
        return if(tasks.keys.contains(id)) {
            tasks[id] = task
            true
        } else {
            false
        }
    }

    fun deleteTask(id: String) {
        tasks.remove(id)
    }
}