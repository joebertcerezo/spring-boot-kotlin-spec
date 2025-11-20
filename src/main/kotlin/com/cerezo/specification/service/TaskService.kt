package com.cerezo.specification.service

import com.cerezo.specification.dto.request.TaskCreateRequest
import com.cerezo.specification.dto.response.TaskResponse
import com.cerezo.specification.dto.response.toResponse
import com.cerezo.specification.entity.Task
import com.cerezo.specification.repository.ProjectRepository
import com.cerezo.specification.repository.TaskRepository
import com.cerezo.specification.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TaskService(
  private val taskRepository: TaskRepository,
  private val userRepository: UserRepository,
  private val projectRepository: ProjectRepository,
) {
  fun create(taskCreate: TaskCreateRequest): TaskResponse {
    val findUser =
      userRepository
        .findById(
          taskCreate.userId,
        ).orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND) }
    val findProject =
      projectRepository.findById(taskCreate.projectId).orElseThrow {
        ResponseStatusException(HttpStatus.NOT_FOUND)
      }

    return taskRepository
      .save(
        Task(
          title = taskCreate.title,
          description = taskCreate.description,
          dueDate = taskCreate.dueDate,
          user = findUser,
          project = findProject,
        ),
      ).toResponse()
  }
}
