package com.cerezo.specification.entity

import com.cerezo.specification.constant.ProjectStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "projects")
class Project(
  @Id
  @Column(
    name = "id",
    nullable = false,
    unique = true,
  )
  val id: UUID = UUID.randomUUID(),
  @Column(
    name = "name",
    nullable = false,
  )
  val name: String,
  @Column(
    name = "status",
    nullable = false,
  )
  val status: ProjectStatus = ProjectStatus.TODO,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "owner_id",
    foreignKey = ForeignKey(name = "projects_owner_id_fkey"),
  )
  val user: User,
)
