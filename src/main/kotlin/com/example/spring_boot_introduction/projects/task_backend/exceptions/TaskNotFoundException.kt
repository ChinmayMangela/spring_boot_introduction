package com.example.spring_boot_introduction.projects.task_backend.exceptions

import java.lang.RuntimeException

class TaskNotFoundException(
    private val id: String
): RuntimeException(
    "A quote with ID $id is not found"
)