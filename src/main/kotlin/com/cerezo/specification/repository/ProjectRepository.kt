package com.cerezo.specification.repository

import com.cerezo.specification.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ProjectRepository : JpaRepository<Project, UUID>
