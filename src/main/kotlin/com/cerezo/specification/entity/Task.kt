package com.cerezo.specification.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.Instant
import java.util.UUID

@Entity
@Table(name = "tasks")
class Task(
  @Id
  @Column(
    name = "id",
    nullable = false,
    unique = true,
  )
  val id: UUID = UUID.randomUUID(),
  @Column(
    name = "title",
    nullable = false,
  )
  val title: String,
  @Column(
    name = "description",
    nullable = true,
  )
  val description: String? = null,
  @Column(
    name = "due_date",
    nullable = true,
  )
  val dueDate: Instant? = null,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "assignee_id",
    foreignKey = ForeignKey(name = "tasks_assignee_id_fkey"),
  )
  val user: User,
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "project_id",
    foreignKey = ForeignKey(name = "tasks_project_id_fkey"),
  )
  val project: Project,
)
