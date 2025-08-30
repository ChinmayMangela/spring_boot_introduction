package com.example.spring_boot_introduction.projects.task_backend.mappers

import com.example.spring_boot_introduction.projects.task_backend.dto.CreateTaskRequest
import com.example.spring_boot_introduction.projects.task_backend.dto.TaskResponse
import com.example.spring_boot_introduction.projects.task_backend.entity.TaskEntity
import com.example.spring_boot_introduction.projects.task_backend.model.Task
import com.example.spring_boot_introduction.projects.task_backend.model.TaskStatus
import java.time.Instant


fun CreateTaskRequest.toEntity(): TaskEntity {
    return TaskEntity(
        title = this.title,
        description = this.description,
        createdAt = Instant.now(),
        dueDate = this.dueDate,
        status = TaskStatus.PENDING,
        priority = this.priority
    )
}


fun TaskEntity.toResponse(): TaskResponse {
    return TaskResponse(
        id = this.id.toString(),
        title = this.title,
        description = this.description,
        createdAt = this.createdAt,
        dueDate = this.dueDate,
        status = this.status,
        priority = this.priority
    )
}

