package com.example.spring_boot_introduction.projects.task_backend.entity

import com.example.spring_boot_introduction.projects.task_backend.model.TaskPriority
import com.example.spring_boot_introduction.projects.task_backend.model.TaskStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import java.time.Instant

@Entity
@Table(
    name = "tasks"
)
class TaskEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val description: String,

    @CreationTimestamp
    @Column(nullable = false)
    val createdAt: Instant,

    @Column(nullable = false)
    val dueDate: Instant,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val status: TaskStatus,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val priority: TaskPriority
)