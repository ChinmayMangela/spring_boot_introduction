package com.example.spring_boot_introduction.projects.task_backend.controller

import com.example.spring_boot_introduction.projects.task_backend.dto.TaskRequest
import com.example.spring_boot_introduction.projects.task_backend.dto.TaskResponse
import com.example.spring_boot_introduction.projects.task_backend.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController()
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService
) {
    @PostMapping
    fun addTask(
        @RequestBody taskRequest: TaskRequest
    ): ResponseEntity<TaskResponse> {
        val task = taskService.addTask(taskRequest)
        return ResponseEntity.ok(task)
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: String): ResponseEntity<TaskResponse> {
        val task = taskService.getTask(id)
        return if(task != null) {
            ResponseEntity.ok(task)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllTasks(): ResponseEntity<List<TaskResponse>> {
        val tasks = taskService.getAllTasks()
        return ResponseEntity.ok(tasks)
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: String, @RequestBody task: TaskRequest): ResponseEntity<TaskResponse> {
        val task = taskService.updateTask(id, task)
        return if(task != null) {
            ResponseEntity.ok(task)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTask(
        @PathVariable id: String,
    ): ResponseEntity<TaskResponse> {
        val deletedTask = taskService.deleteTask(id)
        return if(deletedTask != null) {
            ResponseEntity.ok(deletedTask)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}