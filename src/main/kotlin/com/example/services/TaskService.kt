// Lab 6, Step 4: Create the Service
package com.example.services

import com.example.models.CreateTaskRequest
import com.example.models.Task
import com.example.repositories.InMemoryTaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService(private val repository: InMemoryTaskRepository) {
    fun getAllTasks(): List<Task> = repository.findAll()
    fun getTask(id: Long): Task? = repository.findById(id)
    fun createTask(request: CreateTaskRequest): Task = repository.create(request.title, request.description, request.priority)
    fun updateTask(id: Long, request: CreateTaskRequest): Task? = repository.update(id, request.title, request.description, request.priority)
    fun toggleTask(id: Long): Task? = repository.toggleCompleted(id)
    fun deleteTask(id: Long): Boolean = repository.delete(id)
    fun getCompletedTasks(): List<Task> = repository.findByCompleted(true)
    fun getPendingTasks(): List<Task> = repository.findByCompleted(false)
    fun getHighPriorityTasks(): List<Task> = repository.findByPriorityGreaterThan(3)
}