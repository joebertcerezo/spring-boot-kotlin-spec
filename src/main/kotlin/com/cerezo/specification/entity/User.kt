package com.cerezo.specification.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
class User(
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
    name = "email",
    nullable = false,
    unique = true,
  )
  val email: String,
)
