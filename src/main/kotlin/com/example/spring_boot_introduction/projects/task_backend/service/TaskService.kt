package com.example.spring_boot_introduction.projects.task_backend.service

import com.example.spring_boot_introduction.projects.task_backend.dto.CreateTaskRequest
import com.example.spring_boot_introduction.projects.task_backend.dto.TaskResponse
import com.example.spring_boot_introduction.projects.task_backend.dto.UpdateTaskRequest
import com.example.spring_boot_introduction.projects.task_backend.entity.TaskEntity
import com.example.spring_boot_introduction.projects.task_backend.exceptions.TaskNotFoundException
import com.example.spring_boot_introduction.projects.task_backend.mappers.toEntity
import com.example.spring_boot_introduction.projects.task_backend.mappers.toResponse
import com.example.spring_boot_introduction.projects.task_backend.model.Task
import com.example.spring_boot_introduction.projects.task_backend.repository.TaskRepository
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.UUID

@Service
class TaskService(
    private val taskRepository: TaskRepository
) {

    fun addTask(task: CreateTaskRequest): TaskResponse {
        val task = taskRepository.save(
            task.toEntity()
        )
        return task.toResponse()
    }


    fun findTaskById(id: Long): TaskResponse {
        val task = taskRepository.findById(id).orElseThrow {
            TaskNotFoundException(id = id.toString())
        }

        return task.toResponse()
    }


    fun findAllTask(): List<TaskResponse> {
        return taskRepository.findAll().map {
            it.toResponse()
        }
    }

    fun updateTask(id: Long, newTask: UpdateTaskRequest): TaskResponse {
        val oldTask = taskRepository.findById(id).orElseThrow {
            TaskNotFoundException(id.toString())
        }

        val updatedTask = TaskEntity(
            id = oldTask.id,
            title = newTask.title ?: oldTask.title,
            description = newTask.description ?: oldTask.description,
            createdAt = oldTask.createdAt, // preserve original creation time
            dueDate = newTask.dueDate ?: oldTask.dueDate,
            status = newTask.status ?: oldTask.status,
            priority = newTask.priority ?: oldTask.priority
        )

        val savedTask = taskRepository.save(updatedTask)
        return savedTask.toResponse()

    }


    fun deleteTask(id: Long): TaskResponse {
        val task = taskRepository.findById(id).orElseThrow {
            TaskNotFoundException(id.toString())
        }

        taskRepository.deleteById(id)
        return task.toResponse()
    }
}