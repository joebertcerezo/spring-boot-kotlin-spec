package com.cerezo.specification.specification

import com.cerezo.specification.dto.filters.ProjectFilter
import com.cerezo.specification.entity.Project
import com.cerezo.specification.entity.User
import org.springframework.data.jpa.domain.Specification

object ProjectSpec {
  fun filterBy(filter: ProjectFilter): Specification<Project> = Specification.unrestricted<Project>()
    .and(hasFieldLike("name", filter.name))
    .and(hasFieldLike("status", filter.status?.name))
    .and(hasUsernameOrEmail(filter.userEmail))
    .and(hasUsernameOrEmail(filter.userName))

  fun <T> hasFieldEqual(
    field: String,
    value: T?,
  ): Specification<Project> =
    Specification { root, _, cb ->
      value?.let { cb.equal(root.get<T>(field), it) } ?: cb.conjunction()
    }

  fun <T> hasAnyFieldEqual(
    fields: List<String>,
    value: T?,
  ): Specification<Project> =
    Specification { root, _, cb ->
      value?.let {
        val predicates =
          fields.map { field ->
            cb.equal(root.get<T>(field), it)
          }
        cb.or(*predicates.toTypedArray())
      } ?: cb.conjunction()
    }

  fun hasFieldLike(
    field: String,
    value: String?,
  ): Specification<Project> =
    Specification { root, _, cb ->
      value?.let { cb.like(root.get(field), "%$it%") } ?: cb.conjunction()
    }

  fun hasUsernameOrEmail(nameOrUsername: String?): Specification<Project>? =
    if(nameOrUsername.isNullOrBlank()){
      null
    } else {
      Specification { root, _, builder ->
        val userJoin = root.join<Project, User>("user")
        val likePattern = "%${nameOrUsername.trim().lowercase()}%"
        builder.or(
          builder.like(userJoin.get("name"), likePattern),
          builder.like(userJoin.get("email"), likePattern)
        )
      }
    }
}
