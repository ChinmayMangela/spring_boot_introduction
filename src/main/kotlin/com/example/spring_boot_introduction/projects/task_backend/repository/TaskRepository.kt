package com.example.spring_boot_introduction.projects.task_backend.repository

import com.example.spring_boot_introduction.projects.task_backend.entity.TaskEntity
import org.springframework.data.jpa.repository.JpaRepository


interface TaskRepository: JpaRepository<TaskEntity, Long>