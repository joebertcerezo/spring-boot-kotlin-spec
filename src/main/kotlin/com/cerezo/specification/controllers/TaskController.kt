package com.cerezo.specification.controllers

import com.cerezo.specification.dto.request.TaskCreateRequest
import com.cerezo.specification.dto.response.TaskResponse
import com.cerezo.specification.service.TaskService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.base-path}/tasks")
class TaskController(
  private val taskService: TaskService,
) {
  @PostMapping
  fun create(
    @Valid @RequestBody taskCreate: TaskCreateRequest,
  ): ResponseEntity<TaskResponse> {
    val response = taskService.create(taskCreate)
    return ResponseEntity.status(HttpStatus.CREATED).body(response)
  }
}
