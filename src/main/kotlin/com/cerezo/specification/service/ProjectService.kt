package com.cerezo.specification.service

import com.cerezo.specification.dto.request.ProjectCreateRequest
import com.cerezo.specification.dto.response.ProjectResponse
import com.cerezo.specification.dto.response.toResponse
import com.cerezo.specification.entity.Project
import com.cerezo.specification.repository.ProjectRepository
import com.cerezo.specification.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ProjectService(
  private val userRepository: UserRepository,
  private val projectRepository: ProjectRepository,
) {
  fun create(projectCreate: ProjectCreateRequest): ProjectResponse {
    val findUser =
      userRepository.findById(projectCreate.userId).orElseThrow {
        ResponseStatusException(HttpStatus.NOT_FOUND)
      }

    val project = Project(name = projectCreate.name, status = projectCreate.status, user = findUser)
    return projectRepository.save(project).toResponse()
  }
}
