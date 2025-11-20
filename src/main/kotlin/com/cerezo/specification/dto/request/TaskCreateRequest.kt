package com.cerezo.specification.dto.request

import java.time.Instant
import java.util.UUID

data class TaskCreateRequest(
  val title: String,
  val description: String?,
  val dueDate: Instant,
  val userId: UUID,
  val projectId: UUID,
)
