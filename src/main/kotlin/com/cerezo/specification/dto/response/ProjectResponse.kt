package com.cerezo.specification.dto.response

import com.cerezo.specification.constant.ProjectStatus
import com.cerezo.specification.entity.Project
import com.cerezo.specification.entity.User
import java.util.UUID

data class ProjectResponse(
  val id: UUID,
  val name: String,
  val status: ProjectStatus,
  val user: User,
)

fun Project.toResponse(): ProjectResponse =
  ProjectResponse(
    id = this.id,
    name = this.name,
    status = this.status,
    user = this.user,
  )
