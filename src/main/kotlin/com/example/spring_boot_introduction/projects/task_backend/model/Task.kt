package com.example.spring_boot_introduction.projects.task_backend.model

import java.time.Instant
import java.util.UUID

data class Task(
    val id: String,
    val title: String,
    val description: String,
    val createdAt: Instant,
    val dueDate: Instant,
    val status: TaskStatus = TaskStatus.PENDING,
    val priority: TaskPriority
)

enum class TaskStatus {
    PENDING,
    IN_PROGRESS,
    COMPLETED,
    OVERDUE,
}

enum class TaskPriority {
    LOW,
    MEDIUM,
    HIGH
}
