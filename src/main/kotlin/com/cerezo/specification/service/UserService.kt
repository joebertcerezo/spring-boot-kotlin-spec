package com.cerezo.specification.service

import com.cerezo.specification.dto.request.UserCreateRequest
import com.cerezo.specification.dto.response.UserResponse
import com.cerezo.specification.dto.response.toResponse
import com.cerezo.specification.entity.User
import com.cerezo.specification.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class UserService(
  private val userRepository: UserRepository,
) {
  fun create(userCreate: UserCreateRequest): UserResponse {
    val findUser = userRepository.findByEmail(userCreate.email)
    if (findUser != null) {
      throw ResponseStatusException(HttpStatus.BAD_REQUEST, "User email already exist.")
    }

    val user = User(name = userCreate.name, email = userCreate.email)
    return userRepository.save(user).toResponse()
  }
}
