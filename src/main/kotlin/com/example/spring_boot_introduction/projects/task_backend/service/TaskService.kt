package com.example.spring_boot_introduction.projects.task_backend.service

import com.example.spring_boot_introduction.projects.task_backend.dto.TaskRequest
import com.example.spring_boot_introduction.projects.task_backend.dto.TaskResponse
import com.example.spring_boot_introduction.projects.task_backend.model.Task
import com.example.spring_boot_introduction.projects.task_backend.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {
    fun addTask(taskRequest: TaskRequest): TaskResponse {
        val task = Task(
            id = UUID.randomUUID().toString(),
            title = taskRequest.title,
            description = taskRequest.description,
            createdAt = Instant.now(),
            dueDate = taskRequest.dueDate,
            priority = taskRequest.priority
        )
        taskRepository.addTask(task)
        return task.toResponse()
    }

    fun getTask(id: String): TaskResponse? {
        return taskRepository.getTask(id)?.toResponse()
    }

    fun getAllTasks(): List<TaskResponse> {
        return taskRepository.getAllTasks().map { it.toResponse() }
    }

    fun deleteTask(id: String): TaskResponse? {
        return taskRepository.deleteTask(id)?.toResponse()
    }

    fun updateTask(id: String, taskRequest: TaskRequest): TaskResponse? {
        val existingTask =  taskRepository.getTask(id) ?: return null
        val updatedTask = existingTask.copy(
            title = taskRequest.title,
            description = taskRequest.description,
            dueDate = taskRequest.dueDate,
            priority = taskRequest.priority,
        )

        return taskRepository.updateTask(id, updatedTask)?.toResponse()
    }


    private fun Task.toResponse(): TaskResponse {
        return TaskResponse(
            id = this.id,
            title = this.title,
            description = this.description,
            createdAt = this.createdAt,
            dueDate = this.dueDate,
            status = this.status,
            priority = this.priority
        )
    }
}