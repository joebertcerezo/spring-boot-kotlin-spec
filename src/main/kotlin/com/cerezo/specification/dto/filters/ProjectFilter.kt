package com.cerezo.specification.dto.filters

import com.cerezo.specification.constant.ProjectStatus

class ProjectFilter(
  val name: String?,
  val status: ProjectStatus?,
  val userName: String?,
  val userEmail: String?,
)
