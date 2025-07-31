package com.example.spring_boot_introduction.projects.task_backend.controller
import com.example.spring_boot_introduction.projects.task_backend.dto.CreateTaskRequest
import com.example.spring_boot_introduction.projects.task_backend.dto.TaskResponse
import com.example.spring_boot_introduction.projects.task_backend.dto.UpdateTaskRequest
import com.example.spring_boot_introduction.projects.task_backend.exceptions.TaskNotFoundException
import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import com.example.spring_boot_introduction.projects.task_backend.service.TaskService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController()
@RequestMapping("/tasks")
class TaskController(
    private val taskService: TaskService,
) {
    @PostMapping
    fun addTask(
        @RequestBody taskRequest: CreateTaskRequest,
    ): ResponseEntity<TaskResponse> {
        val task = taskService.addTask(taskRequest)
        return ResponseEntity.ok(task)
    }

    @GetMapping("/{id}")
    fun getTask(
        @PathVariable("id") id: String,
    ): ResponseEntity<TaskResponse> {
        val task = taskService.getTask(id)
        return if (task != null) {
            ResponseEntity.ok(task)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @GetMapping
    fun getAllTasks(
        @RequestParam("q", required = false) query: TaskPriority?
    ): ResponseEntity<List<TaskResponse>> {
        val tasks = taskService.getAllTasks()
        return if (query == null) {
            ResponseEntity.ok(tasks)
        } else {
            val filteredTasks = tasks.filter { it.priority == query }
            ResponseEntity.ok(filteredTasks)
        }
    }


    @PutMapping("/{id}")
    fun updateTask(
        @PathVariable("id") id: String,
        @RequestBody task: UpdateTaskRequest,
    ): ResponseEntity<TaskResponse> {
        val task = taskService.updateTask(id, task)
        return if (task != null) {
            ResponseEntity.ok(task)
        } else {
            throw TaskNotFoundException(id)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteTask(
        @PathVariable("id") id: String,
    ): ResponseEntity<TaskResponse> {
        val deletedTask = taskService.deleteTask(id)
        return if (deletedTask != null) {
            ResponseEntity.ok(deletedTask)
        } else {
            throw TaskNotFoundException(id)
        }
    }
}