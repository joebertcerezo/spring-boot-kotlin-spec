package com.cerezo.specification.controllers

import com.cerezo.specification.dto.request.UserCreateRequest
import com.cerezo.specification.dto.response.UserResponse
import com.cerezo.specification.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
  private val userService: UserService,
) {
  @PostMapping
  fun create(userCreateRequest: UserCreateRequest): ResponseEntity<UserResponse> {
    val user = userService.create(userCreateRequest)
    return ResponseEntity.status(HttpStatus.CREATED).body(user)
  }
}
