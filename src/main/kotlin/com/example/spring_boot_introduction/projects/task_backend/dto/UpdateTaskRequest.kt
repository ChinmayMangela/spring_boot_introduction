package com.example.spring_boot_introduction.projects.task_backend.dto

import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import com.example.spring_boot_introduction.projects.task_backend.model.TaskStatus
import jakarta.validation.constraints.Size
import java.time.Instant

data class UpdateTaskRequest(
    @field:Size(
        min = 5,
        max = 100,
        message = "Title must be between 5 to 200 characters long"
    )
    val title: String? = null,

    @field:Size(
        min = 20,
        max = 1000,
        message = "Description must be between 20 to 1000 characters long"
    )
    val description: String? = null,
    val dueDate: Instant? = null,
    val priority: TaskPriority? = null,
    val status: TaskStatus? = null
)
