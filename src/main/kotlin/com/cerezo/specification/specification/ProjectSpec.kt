package com.cerezo.specification.specification

import com.cerezo.specification.constant.ProjectStatus
import com.cerezo.specification.entity.Task
import org.springframework.data.jpa.domain.Specification

object ProjectSpec {
  fun hasProjectStatus(status: ProjectStatus?): Specification<Task>? =
    if (status == null) {
      null
    } else {
      Specification { root, _, builder ->
        root.get<ProjectStatus>("")
      }
    }
}
