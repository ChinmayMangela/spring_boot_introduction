package com.example.spring_boot_introduction.projects.todobackend.models

import java.time.LocalDate
import java.util.UUID

data class Todo(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val description: String,
    val createdAt: LocalDate,
    val updatedAt: LocalDate,
    var completed: Boolean = false
)

