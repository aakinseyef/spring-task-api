// Lab 6, Step 5: Create the Controller
package com.example.controllers

import com.example.models.CreateTaskRequest
import com.example.models.Task
import com.example.services.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/tasks")
class TaskController(private val taskService: TaskService) {
    @GetMapping fun getAllTasks(): List<Task> = taskService.getAllTasks()
    @GetMapping("/{id}") fun getTaskById(@PathVariable id: Long): ResponseEntity<Task> {
        val task = taskService.getTask(id)
        return if (task != null) ResponseEntity.ok(task) else ResponseEntity.notFound().build()
    }
    @PostMapping @ResponseStatus(HttpStatus.CREATED) fun createTask(@Valid @RequestBody request: CreateTaskRequest): Task = taskService.createTask(request)
    @PutMapping("/{id}") fun updateTask(@PathVariable id: Long, @Valid @RequestBody request: CreateTaskRequest): ResponseEntity<Task> {
        val updated = taskService.updateTask(id, request)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }
    @PatchMapping("/{id}/toggle") fun toggleTask(@PathVariable id: Long): ResponseEntity<Task> {
        val task = taskService.toggleTask(id)
        return if (task != null) ResponseEntity.ok(task) else ResponseEntity.notFound().build()
    }
    @DeleteMapping("/{id}") fun deleteTask(@PathVariable id: Long): ResponseEntity<Void> =
        if (taskService.deleteTask(id)) ResponseEntity.noContent().build() else ResponseEntity.notFound().build()
    @GetMapping("/completed") fun getCompletedTasks(): List<Task> = taskService.getCompletedTasks()
    @GetMapping("/pending") fun getPendingTasks(): List<Task> = taskService.getPendingTasks()
    @GetMapping("/high-priority") fun getHighPriorityTasks(): List<Task> = taskService.getHighPriorityTasks()
}