package com.cerezo.specification.controllers

import com.cerezo.specification.dto.request.ProjectCreateRequest
import com.cerezo.specification.dto.response.ProjectResponse
import com.cerezo.specification.service.ProjectService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.base-path}/projects")
class ProjectController(
  private val projectService: ProjectService,
) {
  @PostMapping
  fun create(
    @Valid @RequestBody projectCreate: ProjectCreateRequest,
  ): ResponseEntity<ProjectResponse> {
    val response = projectService.create(projectCreate)
    return ResponseEntity.status(HttpStatus.CREATED).body(response)
  }
}
