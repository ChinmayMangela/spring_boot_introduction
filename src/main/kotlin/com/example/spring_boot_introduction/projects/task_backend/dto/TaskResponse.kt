package com.example.spring_boot_introduction.projects.task_backend.dto
import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import com.example.spring_boot_introduction.projects.task_backend.model.TaskStatus
import java.time.Instant

data class TaskResponse(
    val id: String,
    val title: String,
    val description: String,
    val status: TaskStatus,
    val createdAt: Instant,
    val dueDate: Instant,
    val priority: TaskPriority
)
