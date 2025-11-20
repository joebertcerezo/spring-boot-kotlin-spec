package com.cerezo.specification.service

import com.cerezo.specification.controllers.HealthCheckController
import com.cerezo.specification.dto.request.UserCreateRequest
import org.springframework.stereotype.Service

@Service
class UserService(
  private val userController: HealthCheckController
) {
  fun create(user: UserCreateRequest): 
}
