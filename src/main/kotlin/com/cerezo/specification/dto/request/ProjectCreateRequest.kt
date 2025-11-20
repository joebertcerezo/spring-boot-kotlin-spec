package com.cerezo.specification.dto.request

import com.cerezo.specification.constant.ProjectStatus
import java.util.UUID

data class ProjectCreateRequest(
  val name: String,
  val status: ProjectStatus,
  val userId: UUID,
)
