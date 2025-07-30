package com.example.spring_boot_introduction.projects.task_backend.dto

import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import java.time.Instant

data class CreateTaskRequest(
    val title: String,
    val description: String,
    val dueDate: Instant,
    val priority: TaskPriority
)
