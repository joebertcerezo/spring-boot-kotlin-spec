package com.cerezo.specification.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig {
  @Bean
  fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
    http
      .cors { }
      .csrf { it.disable() }
      .securityMatcher("/api/v1/**")
      .sessionManagement { it.sessionCreationPolicy(SessionCreationPolicy.STATELESS) }
      .build()
}
