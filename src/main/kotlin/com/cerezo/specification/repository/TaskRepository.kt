package com.cerezo.specification.repository

import com.cerezo.specification.entity.Task
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface TaskRepository :
  JpaRepository<Task, UUID>,
  JpaSpecificationExecutor<Task>
