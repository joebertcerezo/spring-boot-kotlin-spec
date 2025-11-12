package com.cerezo.specification.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
  @GetMapping
  fun index(): ResponseEntity<String> = ResponseEntity.status(HttpStatus.OK).body("Server running...")
}
