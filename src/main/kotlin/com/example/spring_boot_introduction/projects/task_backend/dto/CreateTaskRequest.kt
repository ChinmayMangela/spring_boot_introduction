package com.example.spring_boot_introduction.projects.task_backend.dto

import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import jakarta.validation.constraints.Size
import java.time.Instant
data class CreateTaskRequest(
    @field:Size(
        min = 5,
        max = 100,
        message = "Title must be between 5 to 100 character long"
    )
    val title: String,
    @field:Size(
        min = 10,
        max = 1000,
        message = "Description must be between 10 to 1000 character long"
    )
    val description: String,
    val dueDate: Instant,
    val priority: TaskPriority,
)
