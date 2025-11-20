package com.cerezo.specification.dto.response

import com.cerezo.specification.entity.User

data class UserResponse(
  val name: String,
  val email: String,
)

fun User.toResponse(): UserResponse =
  UserResponse(
    name = this.name,
    email = this.email,
  )
