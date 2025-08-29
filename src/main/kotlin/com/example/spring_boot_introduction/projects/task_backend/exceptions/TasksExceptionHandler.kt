package com.example.spring_boot_introduction.projects.task_backend.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
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

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun onValidationFailed(e: MethodArgumentNotValidException): ResponseEntity<Map<String, Any>> {
        val map = mutableMapOf<String, Any>()
        e.bindingResult.fieldErrors.forEach { error ->
            map[error.field] = error.defaultMessage ?: "Validation Failed"
        }
        return ResponseEntity.badRequest().body(map)
    }

}