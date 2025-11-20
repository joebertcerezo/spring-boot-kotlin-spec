package com.cerezo.specification.dto.response

import com.cerezo.specification.entity.Project
import com.cerezo.specification.entity.Task
import com.cerezo.specification.entity.User
import java.time.Instant
import java.util.UUID

data class TaskResponse(
  val id: UUID,
  val title: String,
  val description: String?,
  val dueDate: Instant?,
  val assignee: User,
  val project: Project,
)

fun Task.toResponse(): TaskResponse =
  TaskResponse(
    id = this.id,
    title = this.title,
    description = this.description,
    dueDate = this.dueDate,
    assignee = this.user,
    project = this.project,
  )
