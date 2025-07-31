package com.example.spring_boot_introduction.projects.task_backend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class TasksExceptionHandler {

    @ExceptionHandler(TaskNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun onTaskNotFound(e: TaskNotFoundException) = mapOf(
        "code" to "TASK_NOT_FOUND",
        "message" to e.message
    )
}